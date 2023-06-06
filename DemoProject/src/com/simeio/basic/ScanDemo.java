/**
 * 
 */
package com.simeio.basic;

import java.util.Scanner;

/**
 * @author kkolluru
 *
 */
public class ScanDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter inputs");
		String name = sc.next();
		String city = sc.next();
		System.out.println(name);
		System.out.println(city);
		int pincode = sc.nextInt();
		System.out.println(pincode);
		sc.nextLine();
		sc.useDelimiter("\t");
		 name = sc.next();
		 city = sc.next();
		System.out.println("name is " + name);
		System.out.println("city is " + city);
		 String pin = sc.next();
		System.out.println("pin is " + pin);
		sc.next();
		sc.close();
		
	}

}
