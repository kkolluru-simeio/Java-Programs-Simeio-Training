package com.oops.inheritance.abstraction;

public class Branch1 extends Bank {
	
	String name;
	String city;
	int staffCount;

	public Branch1(int carLoanPercent,int houseLoanPercent, int eduLoanPercent ) {
		super(carLoanPercent,houseLoanPercent, eduLoanPercent);
	}

	@Override
	void carLoan() {
		System.out.println("Car loan is " + this.getCarLoanPercent());

	}

	@Override
	void homeLoan() {
		System.out.println("House loan is " + this.getHouseLoanPercent());

	}

	@Override
	void eduLoan() {
		System.out.println("Education loan is " + this.getEduLoanPercent());
	}
	
	void printBRDetails() {
		System.out.println("name "+ this.name);
		System.out.println("city" + this.city);
		System.out.println("staffcount " +this.staffCount);
	}

}
