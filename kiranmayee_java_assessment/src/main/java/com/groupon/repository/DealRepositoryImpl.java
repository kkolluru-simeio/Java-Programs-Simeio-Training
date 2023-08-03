package com.groupon.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.groupon.model.Deal;
import com.groupon.utils.DealQueries;

@Component
public class DealRepositoryImpl implements IDealRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public void addDeal(Deal deal) {
		String sql = DealQueries.INSERTQUERY;
		Object[] dealArray = {deal.getOutletId(),  deal.getExpiryDate(), deal.getOriginalPrice(), deal.getDiscountedPrice(), deal.getCategory(), deal.getNoOfPurchases()};
		jdbcTemplate.update(sql, dealArray);
		
	}

	@Override
	public int updateDeal(Deal deal) {
		Object[] dealArray = {deal.getOutletId(),  deal.getExpiryDate(), deal.getOriginalPrice(), deal.getDiscountedPrice(), deal.getCategory(), deal.getNoOfPurchases(), deal.getDealId()};
		return jdbcTemplate.update(DealQueries.UPDATEQUERY, dealArray);
	}

	@Override
	public void deleteDeal(int dealId) {
		jdbcTemplate.update(DealQueries.DELETEQUERY, dealId);
		
	}

	@Override
	public List<Deal> findAllDeals() {
		return jdbcTemplate.query(DealQueries.QUERYALL, new DealMapper());
	}
	
	@Override
	public Deal findDealById(int dealId) {
		return jdbcTemplate.queryForObject(DealQueries.QUERYBYID, new DealMapper(), dealId);
		
	}

	@Override
	public List<Deal> findDealsByOutletLocation(String city, String area) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deal> findDealsByCategory(String category) {
		return jdbcTemplate.query(DealQueries.QUERYBYCATEGORY, new DealMapper(), category);
	}

	@Override
	public List<Deal> findDealsByOutletName(String outletName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deal> findDealsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deal> findDealsByExpiryDate() {
		return jdbcTemplate.query(DealQueries.QUERYBYEXPIRYDATE, new DealMapper());

	}

	@Override
	public List<Deal> findDealsByDiscountedPrice() {
		return jdbcTemplate.query(DealQueries.QUERYBYDISCOUNTEDPRICE, new DealMapper());

	}
	
	@Override
	public List<Deal> findDealsByNoOfPurchases() {
		return jdbcTemplate.query(DealQueries.QUERYBYNOOFPURCHASES, new DealMapper());

	}


	

}
