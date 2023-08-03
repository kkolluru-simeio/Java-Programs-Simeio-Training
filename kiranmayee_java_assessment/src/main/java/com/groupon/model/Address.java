package com.groupon.model;

public class Address {

	private String houseNo;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String State;
	
	
	public Address() {
		super();
	}


	public Address(String houseNo, String addressLine1, String addressLine2, String city, String state) {
		super();
		this.houseNo = houseNo;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		State = state;
	}


	public String getHouseNo() {
		return houseNo;
	}


	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}
	
	
	
}
