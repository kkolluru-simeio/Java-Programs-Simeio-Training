package com.simeio.construct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class StudentMain {

	public static void main(String[] args) {


		ApplicationContext context = new AnnotationConfigApplicationContext("com.simeio.construct");
		
		
		Student student = context.getBean("student", Student.class);
		
		
		System.out.println(student);
		
		AbstractApplicationContext absContext = (AbstractApplicationContext) context;
		

		
		
		absContext.close();

	}

}
