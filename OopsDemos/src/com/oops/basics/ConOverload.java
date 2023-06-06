package com.oops.basics;

public class ConOverload {
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle("Rx100");
		Vehicle vehicle3 = new Vehicle("RayZR", "Yamaha");
		Vehicle vehicle4 = new Vehicle("RayZRX", "Yamama", 110000.00 );
		
		vehicle1.getDetails();
		vehicle2.getDetails();
		vehicle3.getDetails();
		vehicle4.getDetails();
	}

}
