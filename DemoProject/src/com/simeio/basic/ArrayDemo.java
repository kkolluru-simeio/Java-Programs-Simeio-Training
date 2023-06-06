package com.simeio.basic;

public class ArrayDemo {

	public static void main(String[] args) {
		int[] marks = new int[3];
		marks[0] = 10;
		marks[1] = 20;
		marks[2] = 30;
		int[] m1 = {10, 20};
		int[] m2 = new int[]{10, 20};
		// marks[3] = 10;
		int sum = 0;
		for (int i = 0; i < marks.length; i++) {
			sum += marks[i];
		}
		System.out.println(sum);

		sum = 0;
		for (int i : marks)
			sum += i;
		System.out.println(sum);
	}

}
