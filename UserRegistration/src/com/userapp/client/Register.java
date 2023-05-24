package com.userapp.client;

import java.util.Scanner;

import com.userapp.exceptions.NameExistsException;
import com.userapp.exceptions.TooLongException;
import com.userapp.exceptions.TooShortException;
import com.userapp.service.IValidationService;
import com.userapp.service.ValidationServiceImpl;

public class Register {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String username = sc.nextLine();
		IValidationService iValidationService = new ValidationServiceImpl();
		do {
	
		try {
		if(iValidationService.validateUsername(username))
		{
			
			System.out.println("Enter password");
			String password = sc.nextLine();
		
				if(iValidationService.validatePassword(password)) {
					System.out.println("valid user");
				}
			
		}
		
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Enter username");
		username = sc.nextLine();
		}while(username!="/n");
		

	}

}
