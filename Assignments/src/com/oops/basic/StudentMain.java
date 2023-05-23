package com.oops.basic;

import java.util.Scanner;

public class StudentMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Student[] students = new Student[2];
		for(int i = 0; i < 2 ; i++) {
		System.out.println("Enter student name");
		String name = sc.nextLine();
		System.out.println("Enter student department");
		String department = sc.nextLine();
		System.out.println("Enter student id");
		int id = sc.nextInt();
		int[] marks = new int[5];
		System.out.println("Enter student marks for 5 subjects");
		for(int j = 0; j < 5;j++) {
			marks[j] = sc.nextInt();
		}
		sc.nextLine();
		Student student = new Student(name, department, id, marks);
		students[i] = student;
		}
		System.out.println(students[0].name + " received Grade " + students[0].getGrades());
		System.out.println(students[1].name + " received Grade " + students[1].getGrades());
		
	}

}
