package com.simeio.inter;

public class Car extends Vehicle implements Accessories {

	public Car(String model, String brand, double price) {
		super(model, brand, price);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void externalAcc() {
		System.out.println("Handles");
		
	}

	@Override
	public void internalAcc() {
		System.out.println("Bose speakers");
		
	}

	@Override
	void showMileage() {
		System.out.println("Mileage is 18KMPH");
		
	}
	
	

}
