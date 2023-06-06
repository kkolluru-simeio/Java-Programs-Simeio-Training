package com.simeio.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapDemo {
	
	public static void main(String[] args) {
		List<String> courses = Arrays.asList("java", ".net", "js", "c++","java", "html");
		
		Function<String, String> func = (str) -> str.toUpperCase();
		List<String> mappedCourses = courses.stream().map(func).collect(Collectors.toList());
		
		System.out.println(mappedCourses);
		
		
		 Arrays.asList("java", ".net", "js", "c++","java", "html").stream().map(str -> str.length()).forEach(System.out::println);
		
 	}

}
