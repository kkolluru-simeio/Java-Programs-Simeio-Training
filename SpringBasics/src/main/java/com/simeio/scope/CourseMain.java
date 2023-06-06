package com.simeio.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simeio.basic.Employee;

public class CourseMain {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.simeio.scope");
		
		Course course1 = (Course)context.getBean("course");
		
		System.out.println(course1);
		
		Course course2 = (Course)context.getBean("course");
		
		System.out.println(course2);
		
		course1.setCourseName("React");
		
		System.out.println(course1.getCourseName());
		System.out.println(course2.getCourseName());

	}

}
