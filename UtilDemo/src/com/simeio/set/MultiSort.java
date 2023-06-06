package com.simeio.set;

import java.util.Comparator;

public class MultiSort implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		
		if(o1.getBrand().compareTo(o2.getBrand()) == 0)
			return o1.getModel().compareTo(o2.getModel());
		return o1.getBrand().compareTo(o2.getBrand()) ;
		
			}
	

}
