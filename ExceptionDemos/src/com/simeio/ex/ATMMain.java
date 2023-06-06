package com.simeio.ex;

public class ATMMain {
	
	public static void main(String[] args) {
		System.out.println("In ATM");
		Bank bank = new Bank();
		try {
		bank.withdraw(1000);
		System.out.println("Amount withdrawn successfully");
		}
		catch(Exception e) {
			System.out.println("system error");
		}
		
		System.out.println("Try again");
		
		
	}
	
	

}
