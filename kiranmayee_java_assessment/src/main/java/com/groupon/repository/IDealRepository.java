package com.groupon.repository;

import java.util.List;

import com.groupon.model.Deal;

public interface IDealRepository {

	void addDeal(Deal deal);
	
	int updateDeal(Deal deal);
	
	void deleteDeal(int dealId);
	
	List<Deal> findAllDeals();
	
	Deal findDealById(int dealId);
	
	List<Deal> findDealsByCategory( String category);
	
	List<Deal> findDealsByOutletLocation( String city, String area);

	List<Deal> findDealsByOutletName(  String outletName);
	
	List<Deal> findDealsByCity(  String city);
	
	List<Deal> findDealsByDiscountedPrice();
	
	List<Deal> findDealsByExpiryDate();
	
	List<Deal> findDealsByNoOfPurchases();
	

}
