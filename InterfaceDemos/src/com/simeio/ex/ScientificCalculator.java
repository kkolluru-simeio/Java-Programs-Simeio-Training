package com.simeio.ex;

public class ScientificCalculator extends BaseCalculator implements IScientific {


	@Override
	public void squareRoot(int x) {
		System.out.println("square root is " + Math.sqrt(x));
		
	}

	@Override
	public void cube(int x) {
		System.out.println("cube is " + (x*x*x));
		
	}

}
