package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exceptions.InValidVoterException;
import com.voterapp.service.ElectionBoothImpl;
import com.voterapp.service.IElectionBooth;

public class Voter {
	
	public static void main(String[] args) {
		IElectionBooth iElectionBooth = new ElectionBoothImpl();
		
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Enter voter details");
			System.out.println("Enter age");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter city");
			String city = sc.nextLine();
			System.out.println("Enter voter ID");
			int voterId = sc.nextInt();
		try {
			
		if(iElectionBooth.checkEligibility(age, city, voterId))
		{
			
		System.out.println("Go ahead and vote");
		}
		
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		}while(true);
	}
}
