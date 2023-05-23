package com.java.basics;

import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		String[] userNames = new String[10];
		userNames[0] = "kiran";
		userNames[1] = "kk";
		userNames[2] = "katya";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username to login");
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
				System.out.println("Login successful");
			else {
				
				System.out.println("Invalid username");
			}
			System.out.println("Enter username to Login");
			user = sc.next();
		} while (user != "quit" || user != "Quit");

	}
}
