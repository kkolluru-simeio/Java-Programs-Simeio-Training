package com.simeio.diamondProblem;

public interface IBonusCalculator {
	
	void calcInterest(double amount);
	
	default void greet() {
		System.out.println("Welcome to IBonusCalculator");
	}

}
