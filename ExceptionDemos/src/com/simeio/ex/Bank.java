package com.simeio.ex;

public class Bank {

	double balance = 2000;
	void withdraw(int amount) throws Exception{
		System.out.println("In Bank");
		try {
		balance-= amount;
		int x = amount /0;
		System.out.println("Banace deducted");
		throw new Exception();
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println("technical error");
			throw e;
		}
		finally {
			System.out.println("db connection closed");
		}
	//	System.out.println("server done");
	}
}
