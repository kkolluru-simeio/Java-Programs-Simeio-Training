package com.groupon.model;

public class Order {
	
	private Integer dealId;
	private String userId;
	private Boolean availabilityStatus;
	
	public Order() {
		super();
	}

	public Order(Integer dealId, String userId, Boolean availabilityStatus) {
		super();
		this.dealId = dealId;
		this.userId = userId;
		this.availabilityStatus = availabilityStatus;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(Boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	@Override
	public String toString() {
		return "Orders [dealId=" + dealId + ", userId=" + userId + ", availabilityStatus=" + availabilityStatus + "]";
	}
	

}
