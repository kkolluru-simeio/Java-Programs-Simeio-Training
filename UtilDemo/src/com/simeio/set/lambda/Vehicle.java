package com.simeio.set.lambda;

public class Vehicle  {

	private String model;
	private String brand;
	private double price;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String model, String brand, double price) {
		this.model = model;
		this.brand = brand;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", brand=" + brand + ", price=" + price + "]";
	}

}

