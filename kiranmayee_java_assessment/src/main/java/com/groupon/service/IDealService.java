package com.groupon.service;

import java.util.List;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.model.Deal;

public interface IDealService {

	void addDeal(Deal deal);

	int updateDeal(Deal deal);

	void deleteDeal(int dealId);

	List<Deal> getAllDeals() throws DealNotFoundException;

	Deal getDealById(int DealId) throws DealNotFoundException;

	List<Deal> getDealsByCategory(String category) throws DealNotFoundException;

	List<Deal> getDealsByDiscountedPrice() throws DealNotFoundException;
	
	List<Deal> getDealsByExpiryDate() throws DealNotFoundException;
	
	List<Deal> getDealsByNoOfPurchases() throws DealNotFoundException;



//	List<Deal> getDealsByOutletLocation( String city, String area) throws DealNotFoundException;

//	List<Deal> getDealsByOutletName(  String outletName) throws DealNotFoundException;

//	List<Deal> getDealsByCity(  String city) throws DealNotFoundException;

}
