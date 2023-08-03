package com.groupon.model;

import java.time.LocalDateTime;


public class DealDTO {
	
	private Integer dealId;
	private Integer outletId;
	private LocalDateTime expiryDate;
	private Double originalPrice;
	private Double discountedPrice;
	private String category;
	private Integer noOfPurchases;
	
	public DealDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DealDTO(Integer dealId, Integer outletId, String expiryDate, Double originalPrice, double discountedPrice,
			String category, Integer noOfPurchases) {
		super();
		this.dealId = dealId;
		this.outletId = outletId;
		this.expiryDate = LocalDateTime.parse(expiryDate);
		this.originalPrice = originalPrice;
		this.discountedPrice = discountedPrice;
		this.category = category;
		this.noOfPurchases = noOfPurchases;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getOutletId() {
		return outletId;
	}

	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getNoOfPurchases() {
		return noOfPurchases;
	}

	public void setNoOfPurchases(Integer noOfPurchases) {
		this.noOfPurchases = noOfPurchases;
	}

	@Override
	public String toString() {
		return "DealDTO [dealId=" + dealId + ", outletId=" + outletId + ", expiryDate=" + expiryDate
				+ ", originalPrice=" + originalPrice + ", discountedPrice=" + discountedPrice + ", category=" + category
				+ ", noOfPurchases=" + noOfPurchases + "]";
	}

	


}
