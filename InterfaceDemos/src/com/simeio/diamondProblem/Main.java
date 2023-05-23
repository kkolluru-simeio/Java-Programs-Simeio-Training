package com.simeio.diamondProblem;

public class Main {

	public static void main(String[] args) {
		
		IBonusCalculator bonusCalculator = new Employee();
		bonusCalculator.calcInterest(10);
		
		ILoanCalculator loanCalculator = new Employee();
		loanCalculator.greet();

	}

}
