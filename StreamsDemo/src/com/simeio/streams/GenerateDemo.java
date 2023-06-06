package com.simeio.streams;

import java.util.stream.Stream;

public class GenerateDemo {
	
	public static void main(String[] args) {
		
		//to create infinite stream
		
	//	Stream.generate(() -> Math.random()).forEach(i -> System.out.println(i));
		
		System.out.println("Generating 10 random numbers");
		
		Stream.generate(() -> (int)(Math.random()*10)).limit(10).forEach(i -> System.out.println(i));
	}

}
