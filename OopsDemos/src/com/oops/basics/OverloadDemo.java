package com.oops.basics;

public class OverloadDemo {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.area(20);
		shape.area((int)2.0);
		double tri = shape.area(10, 12.5f);
		System.out.println("triangle area is " + tri);

		int rect = shape.area(10, 20);
		System.out.println("rectangle area is " + rect);

	}
}
