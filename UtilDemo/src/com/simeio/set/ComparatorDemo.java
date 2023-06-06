package com.simeio.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {
	
	public static void main(String[] args) {
		List<Vehicle> vehicleList = Arrays.asList(new Vehicle("fegwt","vbrg",12346.78),
				new Vehicle("gwtwtg","brsvbrbsfdg",25212346.78),
				new Vehicle("fegwefsdt","brsvbrbsfdg",612343546.78),
				new Vehicle("ewfegewwt","rehytvbrg",45212346.78));
		
		System.out.println("Sorting by brand");
		BrandSort brandSort = new BrandSort();
		Collections.sort(vehicleList, brandSort);
		for(Vehicle vehicle: vehicleList) {
			System.out.println(vehicle);
		}
		System.out.println("Sorting by model");
		ModelSort modelSort = new ModelSort();
		Collections.sort(vehicleList, modelSort);
		for(Vehicle vehicle: vehicleList) {
			System.out.println(vehicle);
		}
		
		System.out.println("Sorting by price");
		PriceSort priceSort = new PriceSort();
		Collections.sort(vehicleList, priceSort);
		for(Vehicle vehicle: vehicleList) {
			System.out.println(vehicle);
		}
		
		System.out.println("Multi");
		MultiSort multiSort = new MultiSort();
		Collections.sort(vehicleList, multiSort);
		for(Vehicle vehicle: vehicleList) {
			System.out.println(vehicle);
		}
		
	}
	
	
}
