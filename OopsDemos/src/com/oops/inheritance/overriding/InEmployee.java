package com.oops.inheritance.overriding;

public class InEmployee {
	
	private String name;
	private double Salary;
	private String city;
	
	public InEmployee(String name, double salary, String city) {
		super();
		this.name = name;
		Salary = salary;
		this.city = city;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getSalary() {
		return Salary;
	}



	public void setSalary(double salary) {
		Salary = salary;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	void calcBonus(double amount) {
		
	}
	
	void print() {
		System.out.println("Hello " + name );
	}
	
}
