package com.oops.basics;

public class EmpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee employee1 = new Employee();
		employee1.setName("kiran");
		employee1.setSalary(100.00);
		employee1.getDetails();

		Employee employee2 = new Employee();
		employee2.setName("katya");
		employee2.setSalary(10089.00);
		System.out.println(employee2.getName() + " " + employee2.getSalary());

		System.out.println(employee2.greet("How are you"));
	}
}
