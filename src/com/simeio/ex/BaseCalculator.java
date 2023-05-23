package com.simeio.ex;

public class BaseCalculator implements ICalculator {

	public BaseCalculator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(int x, int y) {
		
		System.out.println("addition is " + (x+y));
	}

	@Override
	public void diff(int x, int y) {
		
		System.out.println("diff is " + Math.abs(x-y));;
	}

	@Override
	public void product(int x, int y) {
		
		System.out.println("product is " + (x*y));
	}

}
