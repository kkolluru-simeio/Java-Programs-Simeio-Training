package com.oops.basics;

public class VarArgsDemo {
	public static void main(String[] args) {
		
		VarArgsDemo vad = new VarArgsDemo();
		vad.sumOfMarks("kiran", 10,20);
		int[] marks = new int[3];
		marks[0] = 20;
		marks[1] = 30;
		vad.sumOfMarks("kk", marks);
	}
	
	void sumOfMarks(String name, int... marks) {
		System.out.println(name);
		int total =0;
		for(int i:marks)
			total+=i;
		System.out.println("total is " + total);
	}

}
