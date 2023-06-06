package com.simeio.ex;

public class BasicEx {
	
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
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("work done");
	}

}
