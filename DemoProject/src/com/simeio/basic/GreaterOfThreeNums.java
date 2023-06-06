/**
 * 
 */
package com.simeio.basic;

/**
 * @author kkolluru
 *
 */
public class GreaterOfThreeNums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 20;
		int z = 25;
		
		if(x > y && x >z)
			System.out.println("x " + x);
		else if (y>z)
			System.out.println("y " + y);
		else
			System.out.println("z " + z);
		}

}
