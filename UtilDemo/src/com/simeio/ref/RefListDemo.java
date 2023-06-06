package com.simeio.ref;

import java.util.Arrays;

public class RefListDemo {
	
	public static void main(String[] args) {
		
		Arrays.asList("apple","banana","mango").stream().forEach(System.out::println);
		Arrays.asList("apple","banana","mango").stream().map(String::toUpperCase).forEach(System.out::println);
	}

}
