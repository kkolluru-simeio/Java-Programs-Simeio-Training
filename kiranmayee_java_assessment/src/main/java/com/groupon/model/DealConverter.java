package com.groupon.model;

import org.springframework.stereotype.Component;



@Component
public class DealConverter {

	public Deal toEntity(DealDTO dealDTO) {
		
		Deal deal = new Deal();
		deal.setDealId(dealDTO.getDealId());
		 deal.setOutletId(dealDTO.getOutletId());
		 deal.setCategory(dealDTO.getCategory());
		 deal.setDiscountedPrice(dealDTO.getDiscountedPrice());
		 deal.setExpiryDate(dealDTO.getExpiryDate());
		 deal.setNoOfPurchases(dealDTO.getNoOfPurchases());
		 deal.setOriginalPrice(dealDTO.getOriginalPrice());
		return deal;
	}
	
	public DealDTO toDTO(Deal deal) {
		
		DealDTO dealDTO = new DealDTO();
		dealDTO.setDealId(deal.getDealId());
		dealDTO.setOutletId(deal.getOutletId());
		dealDTO.setCategory(deal.getCategory());
		dealDTO.setDiscountedPrice(deal.getDiscountedPrice());
		dealDTO.setExpiryDate(deal.getExpiryDate());
		dealDTO.setNoOfPurchases(deal.getNoOfPurchases());
		dealDTO.setOriginalPrice(deal.getOriginalPrice());
		return dealDTO;
	}
}