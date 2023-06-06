package com.simeio.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {

	@Autowired
	@Qualifier("triangle")
	IShape shape;
	
	/*
	 * void printArea(String shapeName, int x , int y) { switch(shapeName) { case
	 * "square" : shape = new Square(); shape.area(x, y); break;
	 * 
	 * case "rectangle" : shape = new Rectangle(); shape.area(x, y); break;
	 * 
	 * case "triangle" : shape = new Triangle(); shape.area(x, y); break;
	 * 
	 * default: System.out.println("Invalid shape"); }
	 * 
	 * }
	 */
	
	void printArea(String s, int x, int y) {
		shape.area(x, y);
	}
	
	
}
