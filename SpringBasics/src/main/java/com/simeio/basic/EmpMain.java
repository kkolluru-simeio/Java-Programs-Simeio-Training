package com.simeio.basic;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
	
		/*
		 * Employee employee = new Employee();
		 * 
		 * Address address = new Address();
		 * 
		 * address.setCity("bglr"); address.setState("KA");
		 * 
		 * employee.setEmpId(1); employee.setEmpName("kiran");
		 * employee.setAddress(address);
		 * 
		 * System.out.println(employee);
		 */
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.simeio");
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach((bean) -> System.out.println(bean));
		
		// there is a chance for class cast exception if the down casting is done to any wrong class
		Employee employee = (Employee)context.getBean("employee");
		
		System.out.println(employee);
		
		// in below two cases, there is no chance of such exception
		Employee employee1 = (Employee)context.getBean("employee", Employee.class);
		
		System.out.println(employee1);
		
		Employee employee2 = (Employee)context.getBean(Employee.class);
		
		System.out.println(employee2);
		
		((AnnotationConfigApplicationContext)context).close();
		

	}

}
