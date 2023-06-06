/**
 * 
 */
package com.oops.basics;

/**
 * @author kkolluru
 *
 */
public class Employee {

	/**
	 * @param args
	 */
	private String name;
	private double salary;

	public Employee() {

	}

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void getDetails() {
		System.out.println("name " + this.name);
		System.out.println("salary " + this.salary);
	}
	
	public String greet(String msg) {
		return "Welcome " +this.name + ", " + msg; 
	}

}
