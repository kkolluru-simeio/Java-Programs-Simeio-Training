package com.groupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.model.Deal;
import com.groupon.repository.IOrderRepository;

@Component
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	IUserService userService;


	@Override
	public void addDealToOrders(int dealId, String userId, boolean availabilityStatus) {
		orderRepository.addDealToOrders(dealId, userId, availabilityStatus);
	}

	@Override
	public void deleteDealFromOrders(int dealId, String userId) {
		orderRepository.deleteDealFromOrders(dealId, userId);
		
	}

	@Override
	public List<Deal> getAllDealsBoughtByUser(String userId) throws DealNotFoundException {
		userService.getUserById(userId);
		List<Deal> dealList = orderRepository.findAllDealsBoughtByUser(userId);
		if (dealList.isEmpty())
			throw new DealNotFoundException("No deals purchased by user");
		return dealList;
	}

	@Override
	public List<Deal> getUnusedDealsByUser(String userId) throws DealNotFoundException {
		userService.getUserById(userId);
		List<Deal> dealList = orderRepository.findUnusedDealsByUser(userId);
		if (dealList.isEmpty())
			throw new DealNotFoundException("No deals purchased by user");
		return dealList;
	}

	@Override
	public void updateAvailabilityStatus(int dealId, String userId, boolean availabilityStatus) {
		orderRepository.updateAvailabilityStatus(dealId, userId, availabilityStatus);

		
	}
}
