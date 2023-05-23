package com.oops.overloading;

public class Employee {
	
	private String name;
	private String department;
	
	public Employee(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}
	
	double calcBonus(double basicAllowance) {
		return basicAllowance;
		
	}
	double calcBonus(double basicAllowance, double carAllowance) {
		return basicAllowance;
		
	}
	
	double calcBonus(double basicAllowance, double carAllowance, double houseAllowance) {
		return basicAllowance;
		
	}
	
}
