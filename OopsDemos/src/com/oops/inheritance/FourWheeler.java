package com.oops.inheritance;

public class FourWheeler {
	
	String brand;
	String type;
	int year;
	
	
	public FourWheeler(String brand, String type) {
		super();
		this.brand = brand;
		this.type = type;
	}



	public FourWheeler(String brand, String type, int year) {
		super();
		this.brand = brand;
		this.type = type;
		this.year = year;
	}



	public FourWheeler() {
		super();
		this.brand = "Mahi";
		this.type = "LMV";
	}



	void print() {
		System.out.println(brand);
		System.out.println(type);
		System.out.println(year);
	}

}
