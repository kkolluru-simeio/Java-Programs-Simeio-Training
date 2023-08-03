package com.groupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.model.Deal;
import com.groupon.repository.IDealRepository;

@Component
public class DealServiceImpl implements IDealService {

	@Autowired
	IDealRepository dealRepository;
	

	@Override
	public void addDeal(Deal deal) {
		dealRepository.addDeal(deal);

	}

	@Override
	public int updateDeal(Deal deal) {
		
		return dealRepository.updateDeal(deal);
	}

	@Override
	public void deleteDeal(int dealId) {
		dealRepository.deleteDeal(dealId);

	}

	@Override
	public List<Deal> getAllDeals() throws DealNotFoundException {

		List<Deal> dealList = dealRepository.findAllDeals();
		if (dealList.isEmpty())
			throw new DealNotFoundException("No deal found in repo");
		return dealList;
	}

	@Override
	public Deal getDealById(int dealId) throws DealNotFoundException {
		try {
		Deal deal = dealRepository.findDealById(dealId);
		return deal;
		}
		catch(DataAccessException ex) {
			throw new DealNotFoundException("Invalid Id");
		}
	}

	@Override
	public List<Deal> getDealsByCategory(String category) throws DealNotFoundException {
		List<Deal> dealList = dealRepository.findDealsByCategory(category);
		if (dealList.isEmpty())
			throw new DealNotFoundException("No deal found under category " + category);
		return dealList;
	}

	@Override
	public List<Deal> getDealsByDiscountedPrice() throws DealNotFoundException {
		List<Deal> dealList = dealRepository.findDealsByDiscountedPrice();
		if (dealList.isEmpty())
			throw new DealNotFoundException("No deal found in Repo" );
		return dealList;
	}

	@Override
	public List<Deal> getDealsByExpiryDate() throws DealNotFoundException {
		List<Deal> dealList = dealRepository.findDealsByExpiryDate();
		if (dealList.isEmpty())
			throw new DealNotFoundException("No deal found in Repo" );
		return dealList;
	}

	@Override
	public List<Deal> getDealsByNoOfPurchases() throws DealNotFoundException {
		List<Deal> dealList = dealRepository.findDealsByNoOfPurchases();
		if (dealList.isEmpty())
			throw new DealNotFoundException("No deal found in Repo" );
		return dealList;
	}

	
	

	/*
	 * public List<Deal> getDealsByOutletLocation(String city, String area) {
	 * 
	 * return getDealsByOutletLocation(city, area);
	 * 
	 * }
	 */

	/*
	 * @Override public List<Deal> getDealsByOutletName(String outletName) {
	 * return getDealsByOutletName( outletName);
	 * 
	 * 
	 * }
	 */

	/*
	 * @Override public List<Deal> getDealsByCity(String city) { return
	 * getDealsByCity( city);
	 * 
	 * }
	 */

}
