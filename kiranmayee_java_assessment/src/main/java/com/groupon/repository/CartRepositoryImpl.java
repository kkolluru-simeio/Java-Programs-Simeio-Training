package com.groupon.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.groupon.model.Deal;
import com.groupon.utils.CartQueries;
import com.groupon.utils.DealQueries;

@Component
public class CartRepositoryImpl implements ICartRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public void addDealToCart(int dealId, String userId) {
		String sql = CartQueries.INSERTQUERY;
		Object[] dealArray = {dealId, userId};
		jdbcTemplate.update(sql, dealArray);
		
	}

	@Override
	public void deleteDealFromCart(int dealId, String userId) {
		jdbcTemplate.update(CartQueries.DELETEQUERY, dealId, userId);
		
	}

	
	@Override
	public List<Deal> findAllDealsInCart(String userId) {
		return jdbcTemplate.query(CartQueries.QUERYBYUSERID, new DealMapper(), userId);
		
	}



	

}
