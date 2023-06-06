package com.simeio.set.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	
	public static void main(String[] args) {
		List<Vehicle> vehicleList = Arrays.asList(new Vehicle("fegwt","vbrg",12346.78),
				new Vehicle("gwtwtg","brsvbrbsfdg",25212346.78),
				new Vehicle("fegwefsdt","brsvbrbsfdg",612343546.78),
				new Vehicle("ewfegewwt","rehytvbrg",45212346.78));
		
		System.out.println("Sorting by brand");
		Comparator<Vehicle> brandSort = (o1, o2) -> {
			return o1.getBrand().compareTo(o2.getBrand());
		};
		Collections.sort(vehicleList, brandSort);
		System.out.println(vehicleList);
		System.out.println();
		
		System.out.println("Sorting by model");
		Collections.sort(vehicleList, (o1, o2) ->
			 o1.getModel().compareTo(o2.getModel())
		);
		System.out.println(vehicleList);
		System.out.println();
		
		System.out.println("Sorting by price");
		Collections.sort(vehicleList, (o1, o2) -> {
			return ((Double)o1.getPrice()).compareTo((Double)o2.getPrice());
		});
		System.out.println(vehicleList);
		System.out.println();
		
		System.out.println("sort by model if the brand is same ");
		Comparator<Vehicle> multiSort = (o1, o2) -> { if(o1.getBrand().compareTo(o2.getBrand()) == 0)
			return o1.getModel().compareTo(o2.getModel());
		return o1.getBrand().compareTo(o2.getBrand()) ;
		};
		Collections.sort(vehicleList, multiSort);
		System.out.println(vehicleList);
		System.out.println();
	}
	
	
}
