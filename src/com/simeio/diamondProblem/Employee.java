package com.simeio.diamondProblem;

public class Employee implements IBonusCalculator, ILoanCalculator {

	@Override
	public void greet() {
		
		System.out.println("Welcome to Employee");
		IBonusCalculator.super.greet();
		ILoanCalculator.super.greet();

	}


	@Override
	public void calcInterest(double amount) {

		System.out.println("calculating Interest for "+ amount);
		
	}

}
