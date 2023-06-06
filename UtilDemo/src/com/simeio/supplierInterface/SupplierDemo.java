package com.simeio.supplierInterface;

import java.util.function.Supplier;

public class SupplierDemo {
	
	public static void main(String[] args) {
		
		Supplier<String> supplier = () -> "Welcome";
		
		System.out.println(supplier.get());
	}

}
