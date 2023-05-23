package com.oops.basic;

public class ATM {
	public static void main(String[] args) {
		System.out.println("Welcome");
		Bank bank = new Bank(8000);
		boolean successStatus = bank.withdraw(1000);
		if(successStatus)
			System.out.println("Amount withdrawn successfully ");
		else
			System.out.println("Insufficient balance ");
	}

}

class Bank {
	private double balance;
	

	public Bank(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	boolean withdraw(double amount) {
		System.out.println("in bank");
		if(balance - amount > 0) {
		balance = balance-amount;
		return true;
		}
		else
			return false;
			
	}
}
	