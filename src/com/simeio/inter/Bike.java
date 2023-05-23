package com.simeio.inter;

public class Bike extends Vehicle implements Accessories {

	public Bike(String model, String brand, double price) {
		super(model, brand, price);
		// TODO Auto-generated constructor stub
	}


	@Override
	void showMileage() {
		System.out.println("Mileage is 45KMPH");
		
	}


	@Override
	public void externalAcc() {
		System.out.println("Mudguard");
		
	}

	@Override
	public void internalAcc() {
		System.out.println("Navigator");
		
	}

}
