package com.simeio.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simeio.basic.Employee;

public class ShapeMain {

	public static void main(String[] args) {
		
	/*	ShapeFactory shapeFactory = new ShapeFactory();
		
		shapeFactory.printArea("square", 3, 3);
		shapeFactory.printArea("rectangle", 3, 3);
		shapeFactory.printArea("triangle", 3, 3);
	*/
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.simeio.autowiring");
		
		ShapeFactory shapeFactory= (ShapeFactory)context.getBean("shapeFactory", ShapeFactory.class);
		
		shapeFactory.printArea("square", 3, 3);
		
		NewShapeFactory newShapeFactory = (NewShapeFactory)context.getBean("newShapeFactory", NewShapeFactory.class);
		
		newShapeFactory.printArea("square", 2, 2);
		
		newShapeFactory.printArea("rectangle", 5, 5);
		
		newShapeFactory.printArea("triangle", 4, 6);

	}

}
