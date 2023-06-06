package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
//	@RequestMapping(value="/show", method = RequestMethod.GET)
//	@RequestMapping("/show")
	@GetMapping("/show")
	public String showMessage() {
		
		return "Welcome to REST API";
	}
	
	@GetMapping("/view-courses")
	public List<String> ShowCourses() {
		return Arrays.asList("DSA","CG","JAVA","C++");
	}

}
