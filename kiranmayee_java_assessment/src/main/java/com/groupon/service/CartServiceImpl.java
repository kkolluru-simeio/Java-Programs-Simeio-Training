package com.groupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.exceptions.UserNotFoundException;
import com.groupon.model.Deal;
import com.groupon.repository.ICartRepository;

@Component
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartRepository cartRepository;
	
	@Autowired
	IUserService userService;

	@Override
	public void addDealToCart(int dealId, String userId) {
		cartRepository.addDealToCart(dealId, userId);

	}

	@Override
	public void deleteDealFromCart(int dealId, String userId) {
		cartRepository.deleteDealFromCart(dealId, userId);
		
	}

	@Override
	public List<Deal> getAllDealsInCart(String userId) throws DealNotFoundException {
		userService.getUserById(userId);
		List<Deal> dealList = cartRepository.findAllDealsInCart(userId);
		if (dealList.isEmpty())
			throw new DealNotFoundException("No deals added to cart");
		return dealList;
	}

}
