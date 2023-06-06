package com.simeio.FunctionalInterface;

import java.util.Scanner;

interface ICalculator {

	double calculate(double x , double y);
}

enum functions {
	ADD,
	DIFFERENCE,
	PRODUCT,
	DIVISION
}

public class LambdaCalculator {
	public static void main(String[] args) {
		ICalculator icalculator = null;
		System.out.println("Select an operation" );
		for(int i = 0; i < functions.values().length ; i++)
			System.out.println((i+1) + " : " + functions.values()[i]);
		System.out.println("Enter 0 to exit" );
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		
		  do { 
			  switch(userInput) {
				  case 1: 
					  icalculator = (x,y) -> { return x + y; };
		  System.out.println("Additon function " + icalculator.calculate(5, 10));
		  break;
				  case 2: 
		  icalculator = (x,y) -> { return Math.abs(x - y); };
		  System.out.println("Diff function " + icalculator.calculate(5, 10));
		  break;
				  case 3:
		  
		  icalculator = (x,y) -> { return x * y; };
		  System.out.println("Product function " + icalculator.calculate(5, 10));
		  break;
				  case 4:
		  icalculator = (x,y) -> { return x/ y; };
		  System.out.println("Division function " + icalculator.calculate(5, 10));
		  break;
		  default:
			  break;
		  
			  }
			  userInput = sc.nextInt();
		  }while(userInput!=0 && userInput < 5);
		 
	}
}