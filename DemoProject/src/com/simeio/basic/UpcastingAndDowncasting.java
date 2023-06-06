package com.simeio.basic;

public class UpcastingAndDowncasting {

	public static void main(String[] args) {
		int y = 40;
		long x = y;

		long a = 1234566787456l;
		int b = (int) a;
		
		int s = 300;
		System.out.println((byte)s);
		System.out.println(x);
		System.out.println(b);
	}

}
