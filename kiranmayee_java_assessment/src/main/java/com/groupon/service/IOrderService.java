package com.groupon.service;

import java.util.List;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.model.Deal;

public interface IOrderService {

	void addDealToOrders(int dealId, String userId, boolean availabilityStatus);

	void updateAvailabilityStatus(int dealId, String userId, boolean availabilityStatus);

	void deleteDealFromOrders(int dealId, String userId);

	List<Deal> getAllDealsBoughtByUser(String userId) throws DealNotFoundException;

	List<Deal> getUnusedDealsByUser(String userId) throws DealNotFoundException;

}
