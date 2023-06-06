package com.simeio.function;

import java.util.function.Function;

public class UtilFunctionDemo {
	
	public static void main(String[] args) {
		
		Function<String , Integer> func = (str) -> str.length();
		System.out.println(func.apply("kiran"));
		
		Function<Customer , Customer> func1 = (customer) -> {
			customer.setName(customer.getName()+" simeio");
			return customer;
		};
		System.out.println(func1.apply(new Customer("ram", "bglr", 1)));
	}

}
