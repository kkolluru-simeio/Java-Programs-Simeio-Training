package com.oops.basic;

public class Student {
	
	String name;
	String department;
	int id;
	int[] marks;
	

	public Student(String name, String department, int id, int[] marks) {
		super();
		this.name = name;
		this.department = department;
		this.id = id;
		this.marks = marks;
	}

	public void printDetails() {
		System.out.println("Student [name=" + name + ", department=" + department + "]");
	}
	
	public String getGrades( ) {
		
		return average(this.marks) > 80 ?  "A" : average(this.marks) > 60 ? "B" : "C";
		
	}
	
	private int sum(int [] marks) {
		int sum = 0;
		for(int i : marks)
			sum+= i;

	return sum;
	}
	
	private double average(int [] marks) {
		int total = sum(marks);
		return total/marks.length;
	}

}
