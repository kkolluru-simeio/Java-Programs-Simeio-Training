package com.simeio.custom;

public class ATMDemo {
	
	public static void main(String[] args) {
		System.out.println("In ATM");
		ABCBank bank = new ABCBank();
		try {
		bank.withdraw(3000);
		System.out.println("Amount withdrawn successfully");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Try again");
		
		
	}
	
	

}
