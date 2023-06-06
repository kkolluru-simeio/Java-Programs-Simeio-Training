package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.autowiring.ShapeFactory;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class SpringBootBasicApplication implements CommandLineRunner{
	
	ShapeFactory shapeFactory;
	
	@Autowired
	public void setShapeFactory(ShapeFactory shapeFactory) {
		this.shapeFactory = shapeFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		shapeFactory.printArea("square", 4, 7);
		
	}

}
