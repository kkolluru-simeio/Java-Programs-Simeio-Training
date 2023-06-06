package com.oops.basics;

public class Vehicle {

	private String model;
	private String brand;
	private double price;

	public Vehicle() {
		super();
	}

	public Vehicle(String model) {
		this.model = model;
		System.out.println("one parm constructor");
	}

	public Vehicle(String model, String brand) {
		this(model);
		this.brand = brand;
		System.out.println("two parm constructor");
	}

	public Vehicle(String model, String brand, double price) {
		this(model, brand);
		this.price = price;
		System.out.println("three parm constructor");
	}

	public void getDetails() {
		System.out.println("Vehicle details");
		if (model != null)
			System.out.println(this.model);
		if (brand != null)
			System.out.println(this.brand);
		if (price > 0)
			System.out.println(this.price);
	}

}
