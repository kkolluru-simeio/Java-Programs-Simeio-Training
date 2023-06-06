package com.oops.inheritance.abstraction;

public abstract class Branch2 extends Bank {

	public Branch2(int carLoanPercent, int houseLoanPercent, int eduLoanPercent) {
		super(carLoanPercent, houseLoanPercent, eduLoanPercent);
		// TODO Auto-generated constructor stub
	}


	@Override
	void homeLoan() {
		System.out.println("House loan is " + (this.getHouseLoanPercent()+3));

	}

	@Override
	void eduLoan() {
		System.out.println("Education loan is " + (this.getEduLoanPercent()+3));

	}
	
	void loanPayment() {
		System.out.println("loan payment accepted");
	}

}
