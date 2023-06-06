package com.simeio.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterDemo {
	
	public static void main(String[] args) {
		
		List<String> fruits = List.of("apple", "banana", "pear", "strawberry");
		
		Predicate<String> pred = (str) -> str.length() > 5;
		List<String> selectedFruits = fruits.stream().filter(pred).collect(Collectors.toList());
		System.out.println(selectedFruits);
		
		List<String> courses = Arrays.asList("java", ".net", "js", "c++");
		
		List<String> selectedCourses = courses.stream().filter((str) -> str.startsWith("j")).collect(Collectors.toList());
		System.out.println(selectedCourses);
		
		System.out.println("courses with length of names > = 3");
		
		Iterator<String> iterator = courses.stream().filter(str -> str.length()>=3).sorted().limit(2).iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("printing using for each");
		System.out.println(courses.stream().sorted().collect(Collectors.toList()));
		
		courses.stream().filter(str -> str.length()>=3).sorted().forEach(str -> System.out.println(str.toUpperCase()));
	}

}
