package com.groupon.model;

public class Cart {
	
	
	private Integer dealId;
	private String userId;
	
	public Cart() {
		super();
	}

	public Cart(Integer dealId, String userId) {
		super();
		this.dealId = dealId;
		this.userId = userId;
		
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


	@Override
	public String toString() {
		return "Cart [dealId=" + dealId + ", userId=" + userId + "]";
	}
	
	
	
}
