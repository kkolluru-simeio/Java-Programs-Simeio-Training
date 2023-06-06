package com.simeio.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerMain {

	public static void main(String[] args) {
		
		ArrayList<Customer> customers  = new ArrayList<>();	
		
		customers.add(new Customer("kd","bglr",1));
		customers.add(new Customer("aw","crd",2));
		customers.add(new Customer("kk","bglr",3));
		customers.add(new Customer("bb","crd",4));
		customers.add(new Customer("kw","hyd",3));
		
		
		System.out.println("using Iterator");
		Iterator<Customer> iterator = customers.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("using for each");
		for(Customer cust : customers)
			System.out.println(cust);
		
		System.out.println("Enter a city to filter:");
		
		Scanner sc = new Scanner(System.in);
		
		String city = sc.nextLine();
		
		ArrayList<Customer> customersByCity = new ArrayList<>();	
		
		for(Customer cust : customers)
		{
			if(cust.getCity().equals(city))
				customersByCity.add(cust);
		}
		System.out.println(customersByCity);
		
		Collections.sort(customers);
		System.out.println(customers);
			
	}
}
