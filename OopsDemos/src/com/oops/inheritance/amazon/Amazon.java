package com.oops.inheritance.amazon;

public class Amazon {

	private String userName;
	private double subfee;
	private int durationInMonths;
	
	public Amazon(String userName, double subfee, int durationInMonths) {
		super();
		this.userName = userName;
		this.subfee = subfee;
		this.durationInMonths = durationInMonths;
	}
	
	void showSubDetails() {
		System.out.println("subscription fee is " + subfee);
		System.out.println("Duration is " + durationInMonths);
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getSubfee() {
		return subfee;
	}

	public void setSubfee(double subfee) {
		this.subfee = subfee;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	void print() {
		System.out.println("user name is " + this.userName);
	}
	
	
}

