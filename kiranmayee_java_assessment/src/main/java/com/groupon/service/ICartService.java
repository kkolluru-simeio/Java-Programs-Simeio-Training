package com.groupon.service;

import java.util.List;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.model.Deal;

public interface ICartService {

	void addDealToCart(int dealId, String userId);

	void deleteDealFromCart(int dealId, String userId);

	List<Deal> getAllDealsInCart(String userId) throws DealNotFoundException;

}
