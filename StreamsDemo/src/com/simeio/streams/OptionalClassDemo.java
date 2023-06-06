package com.simeio.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalClassDemo {
	
	public static void main(String[] args) {
		
		List<String> courses = Arrays.asList("java", ".net", "js", "c++","java", "html");
		
		Optional<String> element = courses.stream().skip(6).findFirst();
		if(element.isPresent()) System.out.println("first element is " + element.get());
		else
			System.out.println("no value is present");
		
		courses.stream().skip(2).findFirst().ifPresent(System.out::println);
		
		courses.stream().skip(6).findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("not present"));
		
		
		Integer inum = Stream.of(1,3,5,7,9).filter(num -> num%2==0).findAny().orElseGet(() -> 0);
		System.out.println(inum);
		
		
		
		
	}

}
