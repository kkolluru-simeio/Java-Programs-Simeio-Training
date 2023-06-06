package com.simeio.custom;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CustomerPredicate {
	public static void main(String[] args) {
		Consumer<Customer> consumer = (customer) -> System.out.println(customer.getCity());
		consumer.accept(new Customer("Ram", "hyd",1));
		
		Supplier<List<Customer>> supplier = () -> Arrays.asList(new Customer("Ram", "hyd",1), new Customer("dsvdav", "avf",2));
		System.out.println(supplier.get());
		
		Predicate<String> predicate = (str) -> {
			if(str.equals("Ram"))
				return true;
			return false;
		};
		predicate.test("Ram");
		
	}

}
