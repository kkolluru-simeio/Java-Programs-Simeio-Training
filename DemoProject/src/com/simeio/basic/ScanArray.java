package com.simeio.basic;

import java.util.Scanner;

public class ScanArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for (int i : arr)
			sum += i;
		System.out.println("sum of inputs is " + sum);
	}
}
