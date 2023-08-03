package com.groupon.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.model.Deal;
import com.groupon.utils.CartQueries;
import com.groupon.utils.OrderQueries;

@Component
public class OrderRepositoryImpl implements IOrderRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addDealToOrders(int dealId, String userId, boolean availabilityStatus) {
		String sql = OrderQueries.INSERTQUERY;
		//availabilityStatus 0 indicates used and 1 indicates unused deals
		Object[] dealArray = {dealId, userId, availabilityStatus?1:0};
		jdbcTemplate.update(sql, dealArray);
		
	}

	@Override
	public void deleteDealFromOrders(int dealId, String userId) {
		jdbcTemplate.update(OrderQueries.DELETEQUERY, dealId, userId);
		
		
	}

	@Override
	public List<Deal> findAllDealsBoughtByUser(String userId) throws DealNotFoundException {
		return jdbcTemplate.query(OrderQueries.QUERYBYUSERID, new DealMapper(), userId);
		
	}

	@Override
	public List<Deal> findUnusedDealsByUser(String userId) throws DealNotFoundException {
		return jdbcTemplate.query(OrderQueries.QUERYUNUSEDDEALSBYUSERID, new DealMapper(), userId, '1');

	}

	@Override
	public void updateAvailabilityStatus(int dealId, String userId, boolean availabilityStatus) {
		jdbcTemplate.update(OrderQueries.UPDATEQUERY, availabilityStatus, dealId, userId);
		
		
	}



	

}
