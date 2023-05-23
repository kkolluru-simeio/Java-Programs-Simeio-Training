package com.java.basics;

import java.util.Scanner;

public class Registration {
	public static void main(String[] args) {
		String[] userNames = new String[10];

		Scanner sc = new Scanner(System.in);
		int userNameIndex = 0;
		System.out.println("Enter username to register");
		String user = sc.next();
		do {

			boolean flag = false;
			for (String u : userNames) {
				System.out.println(u);
				if (u!= null && u.equals(user))
				{ 	
					flag= true;
					
				}
			}
			if(flag)
				System.out.println("Name is not unique");
			else {
				if(userNameIndex == userNames.length-1)
				{
					System.out.println("Maximum users added to db");
					System.exit(1);
				}
				userNames[userNameIndex++] = user;
				System.out.println("You are registered");
			}
			System.out.println("Enter username to register");
			user = sc.next();
		} while (user != "quit" || user != "Quit");

	}
}
