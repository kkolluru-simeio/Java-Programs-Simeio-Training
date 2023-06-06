package com.simeio.ex;

public class FinallyDemo {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome");
		try {
		String val = args[0];
		System.out.println("Value got");
		int num = Integer.parseInt(val);
		System.out.println("Num " + num);
		int result = 100/num;
		System.out.println(result);
		}
		finally {
			System.out.println("completed");
		}
		System.out.println("work done");
	}

}
