package com.simeio.custom;

public class ABCBank {

	double balance = 2000;
	void withdraw(int amount) throws OutOfLimitsException, NegativeBalanceException{
		System.out.println("In Bank");
		try {
			if(amount > 5000)
				throw new OutOfLimitsException("Amount exceed withdrawl limit");
			if(balance - amount < 0 )
				throw new NegativeBalanceException("Negative Balance");
		balance-= amount;
		int x = amount /0;
		System.out.println("Balancce deducted");
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("technical error");
			throw e;
		}
		finally {
			System.out.println("db connection closed");
		}
	//	System.out.println("server done");
	}
}
