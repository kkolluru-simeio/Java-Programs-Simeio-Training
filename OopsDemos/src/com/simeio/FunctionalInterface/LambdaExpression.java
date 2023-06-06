package com.simeio.FunctionalInterface;

public class LambdaExpression {
	
	public static void main(String[] args) {
		IGames igames1 = ()->{
			System.out.println("inside lambda block games");
		};
		igames1.createApps();
		
		IGames igames2 = ()->{
			System.out.println("inside lambda card games");
		};
		igames2.createApps();
	}

}
