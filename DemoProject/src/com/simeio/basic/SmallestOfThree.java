package com.simeio.basic;

public class SmallestOfThree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 20;
		int z = 25;
		
		String  res  = (x < y && x < z) ? x + "is smaller" :(y<z) ? y + "is smaller" : z + "is smaller";
		System.out.println(res);
	}
}
