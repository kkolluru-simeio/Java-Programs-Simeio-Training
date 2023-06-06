package com.simeio.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("area of rectangle" + x + " " + y);

	}

}
