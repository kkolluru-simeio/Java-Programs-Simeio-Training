package com.oops.inheritance.abstraction;

public class SubBranch extends Branch2 {
	
	String name;

	public SubBranch(int carLoanPercent, int houseLoanPercent, int eduLoanPercent) {
		super(carLoanPercent, houseLoanPercent, eduLoanPercent);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	void carLoan() {
		System.out.println("Car loan is " + (this.getCarLoanPercent()+3));

	}
	
	void showSubBranchName() {
		System.out.println(this.name);
	}

}
