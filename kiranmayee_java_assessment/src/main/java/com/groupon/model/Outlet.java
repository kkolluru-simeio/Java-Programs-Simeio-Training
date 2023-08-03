package com.groupon.model;

public class Outlet {
	
	private Integer OutletId;
	private String OutletName;
	private Address address;
	
	public Outlet(Integer outletId, String outletName, Address address) {
		super();
		OutletId = outletId;
		OutletName = outletName;
		this.address = address;
	}

	public Outlet() {
		super();
	}

	public Integer getOutletId() {
		return OutletId;
	}

	public void setOutletId(Integer outletId) {
		OutletId = outletId;
	}

	public String getOutletName() {
		return OutletName;
	}

	public void setOutletName(String outletName) {
		OutletName = outletName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Outlet [OutletId=" + OutletId + ", OutletName=" + OutletName + ", address=" + address + "]";
	}
	
	

}
