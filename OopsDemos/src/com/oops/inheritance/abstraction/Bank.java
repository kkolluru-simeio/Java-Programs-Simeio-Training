package com.oops.inheritance.abstraction;

abstract public class Bank {
	private int carLoanPercent;
	private int houseLoanPercent;
	private int eduLoanPercent;
	abstract void carLoan();
	abstract void homeLoan();
	abstract void eduLoan();
	
	public Bank(int carLoanPercent,int houseLoanPercent, int eduLoanPercent ) {
		this.carLoanPercent = carLoanPercent;
		this.houseLoanPercent = houseLoanPercent;
		this.eduLoanPercent = eduLoanPercent;
	}
	
	public int getCarLoanPercent() {
		return carLoanPercent;
	}
	public void setCarLoanPercent(int carLoanPercent) {
		this.carLoanPercent = carLoanPercent;
	}
	public int getHouseLoanPercent() {
		return houseLoanPercent;
	}
	public void setHouseLoanPercent(int houseLoanPercent) {
		this.houseLoanPercent = houseLoanPercent;
	}
	public int getEduLoanPercent() {
		return eduLoanPercent;
	}
	public void setEduLoanPercent(int eduLoanPercent) {
		this.eduLoanPercent = eduLoanPercent;
	}
	

}
