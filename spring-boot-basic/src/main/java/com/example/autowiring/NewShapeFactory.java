package com.example.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewShapeFactory {
	
	//if more than one bean of same type is available
	
	@Autowired
	@Qualifier("triangle") //autowiring by type
	IShape tshape;
	
	//if bean name is same as the instance variable name
	@Autowired
	IShape shape; // autowiring by name
	
	@Autowired
	IShape rectangle;
	
	
	  void printArea(String shapeName, int x , int y) { switch(shapeName) { case
	  "square" : 
		  	shape.area(x, y); break;
	  
	  case "rectangle" : rectangle.area(x, y); break;
	  
	  case "triangle" : tshape.area(x, y); break;
	  
	  default: System.out.println("Invalid shape"); }
	  
	  }
	 
	

}
