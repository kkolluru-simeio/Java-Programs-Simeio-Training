package com.simeio.inter;

public abstract class Vehicle implements Insurance{
	
	

	private String model;
	private String brand;
	private double price;
	
	public Vehicle(String model, String brand, double price) {
		super();
		this.model = model;
		this.brand = brand;
		this.price = price;
	}
	
	void printDetails() {
		System.out.println("model "+ model + "\n"+ "brand "+ brand + "\n" + "price " + price);
	}
	
	abstract void showMileage() ;

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showTypes() {
		System.out.println("Available insurance types");
		for(String type : Insurance.types) {
			System.out.println(type);
		}
		
	}

}