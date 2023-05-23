package com.java.basics;

public class TwoDArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] marks = new int[3][2];
		
		for(int i=0;i <3; i++)
			for(int j=0;j<2; j++)
				marks[i][j] = i+j;
		
		for(int i=0;i <3; i++)
			for(int j=0;j<2; j++)
				System.out.println(marks[i][j]);
		int sum = 0;
		for(int[] m:marks)
		{
			for(int i:m)
			{
				sum+= i;
			}
		}
		System.out.println(sum);

	}

}
