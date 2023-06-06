package com.simeio.autowiring;

import org.springframework.stereotype.Component;

@Component("shape")
public class Square implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("area of square"+ x + " " + y);

	}

}
