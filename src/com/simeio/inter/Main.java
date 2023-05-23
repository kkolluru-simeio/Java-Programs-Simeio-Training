package com.simeio.inter;

public class Main {

	public static void main(String[] args) {
		
		Vehicle vehicle1 = new Car("Kia","sonet", 1700000);
		vehicle1.showMileage();
		vehicle1.showTypes();
		
		Vehicle vehicle2 = new Bike("Yamaha","Rayzr", 110000);
		vehicle2.showMileage();
		vehicle2.showTypes();
		
		Insurance insurance = new Car("bnv","dash", 1700000);
		insurance.showTypes();
		
		Insurance insurance1 = vehicle1;
		insurance1.showTypes();
		
		Accessories accessories = (Accessories) vehicle1;
		accessories.externalAcc();
		accessories.internalAcc();
	}

}
