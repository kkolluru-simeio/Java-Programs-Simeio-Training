package com.oops.inheritance.overriding;

public class InDeveloper extends InEmployee {
	
	int experience;
	String project;

	public InDeveloper(String name, double salary, String city, String project) {
		super(name, salary, city);
		this.project = project;
	}

	@Override
	void calcBonus(double amount) {
		System.out.println("bonus amount is " + amount*5);
	}
	
	void showAssignedProject() {
		System.out.println(this.getName() + " is assigned to " + this.project);
	}

}
