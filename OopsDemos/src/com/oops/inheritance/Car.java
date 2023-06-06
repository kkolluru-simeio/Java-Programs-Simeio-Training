package com.oops.inheritance;

public class Car extends FourWheeler{
	String category;
	
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Car(String brand, String type, int year, String category) {
		super(brand, type, year);
		this.category = category;
		// TODO Auto-generated constructor stub
	}



	public Car(String brand, String type) {
		super(brand, type);
		// TODO Auto-generated constructor stub
	}

	void print() {
		super.print();
		System.out.println(category);
	}

	void show() {
		System.out.println(category);
	}

}
