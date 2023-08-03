package com.groupon.repository;

import java.util.List;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.model.Deal;

public interface ICartRepository {

	void addDealToCart(int dealId, String userId);

	void deleteDealFromCart(int dealId, String userId);

	List<Deal> findAllDealsInCart(String userId) throws DealNotFoundException;
	

}
