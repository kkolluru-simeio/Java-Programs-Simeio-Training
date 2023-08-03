package com.groupon.repository;

import java.util.List;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.model.Deal;

public interface IOrderRepository {

	void addDealToOrders(int dealId, String userId, boolean availabilityStatus);

	void deleteDealFromOrders(int dealId, String userId);

	List<Deal> findAllDealsBoughtByUser(String userId) throws DealNotFoundException;

	List<Deal> findUnusedDealsByUser(String userId) throws DealNotFoundException;

	void updateAvailabilityStatus(int dealId, String userId, boolean availabilityStatus);


}
