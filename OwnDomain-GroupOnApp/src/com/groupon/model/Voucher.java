package com.groupon.model;

import java.util.Date;

public class Voucher {
	
	private Integer voucherId;
	private String outletName;
	private String outletLocation;
	private String city;
	private Integer discountPercent = 0;
	private Date expiryDate;
	private Double minTransaction;
	private Double maxDiscount;
	private String category;
	
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voucher(Integer voucherId, String outletName, String outletLocation, String city, Integer discountPercent,
			Date expiryDate, Double minTransaction, Double maxDiscount, String category) {
		super();
		this.voucherId = voucherId;
		this.outletName = outletName;
		this.outletLocation = outletLocation;
		this.city = city;
		this.discountPercent = discountPercent;
		this.expiryDate = expiryDate;
		this.minTransaction = minTransaction;
		this.maxDiscount = maxDiscount;
		this.category = category;
	}

	public Integer getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(Integer voucherId) {
		this.voucherId = voucherId;
	}

	public String getOutletName() {
		return outletName;
	}

	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

	public String getOutletLocation() {
		return outletLocation;
	}

	public void setOutletLocation(String outletLocation) {
		this.outletLocation = outletLocation;
	}
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getMinTransaction() {
		return minTransaction;
	}

	public void setMinTransaction(Double minTransaction) {
		this.minTransaction = minTransaction;
	}

	public Double getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(Double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Voucher [voucherId=" + voucherId + ", outletName=" + outletName + ", outletLocation=" + outletLocation
				+ ", city=" + city + ", discountPercent=" + discountPercent + ", expiryDate=" + expiryDate
				+ ", minTransaction=" + minTransaction + ", maxDiscount=" + maxDiscount + ", category=" + category
				+ "]";
	}





}
