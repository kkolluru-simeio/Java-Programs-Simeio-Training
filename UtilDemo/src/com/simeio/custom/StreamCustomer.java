package com.simeio.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCustomer {
	
	public static void main(String[] args) {
		
		ArrayList<Customer> customers  = new ArrayList<>();	
		
		customers.add(new Customer("kd","bglr",1));
		customers.add(new Customer("aw","crd",2));
		customers.add(new Customer("kk","bglr",3));
		customers.add(new Customer("bb","crd",4));
		customers.add(new Customer("kw","hyd",3));
		
		String city = "crd";
		List<Customer> filteredList = customers.stream().filter(customer -> customer.getCity().equals(city)).collect(Collectors.toList());
		System.out.println(filteredList);
		
	}

}
