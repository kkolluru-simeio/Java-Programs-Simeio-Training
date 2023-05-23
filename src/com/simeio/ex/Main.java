package com.simeio.ex;

public class Main {

	public static void main(String[] args) {
		ICalculator iCalculator = new BaseCalculator();
		
		iCalculator.add(5, 4);
		iCalculator.product(3, 5);
		iCalculator.diff(2,9);
		
		IScientific iScientific = new ScientificCalculator();
		
		iScientific.add(5, 3);
		iScientific.product(5, 5);
		iScientific.diff(1,9);
		iScientific.cube(3);
		iScientific.squareRoot(25);

	}

}
