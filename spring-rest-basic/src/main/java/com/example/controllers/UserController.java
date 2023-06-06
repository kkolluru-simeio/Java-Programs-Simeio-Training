package com.example.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/greet/{username}/{city}")
	public String greetUser(@PathVariable("username") String name, @PathVariable("city") String city) {
		return "Welcome " + name + " from " + city;
	}

	@GetMapping("/courses/{type}")
	public List<String> viewCourses(@PathVariable("type") String type) {
		if (type.equals("web"))
			return Arrays.asList("HTML", "CSS", "ANGULAR");
		return Arrays.asList("SQL", "PL/SQL", "RDBMS");

	}

	// request format: http://localhost:8080/greet-customer?name=kiran&city=hyd
	@GetMapping("/greet-customer")
	public String greetCustomer(String name, String city) {
		return "Welcome " + name + " from " + city;
	}

	// request format: http://localhost:8080/greet-you?myname=kiran&city=hyd

	@GetMapping("/greet-you")
	public String greetYou(@RequestParam("myname") String name, String city) {
		return "Welcome " + name + " from " + city;
	}

	@GetMapping("/show-cities")
	public Map<String, List<String>> showCities(@RequestParam("mstate") String state) {

		Map<String, List<String>> stateWiseCities = new HashMap<>();
		if (state.equals("KA")) {
			stateWiseCities.put("KA", Arrays.asList("BGLR", "MGLR", "MYSR"));

		} else if (state.equals("TL")) {
			stateWiseCities.put("TL", Arrays.asList("HYD", "NZBD", "SDPET"));

		} else if (state.equals("AP")) {
			stateWiseCities.put("AP", Arrays.asList("VZM", "SLR", "VZG"));

		}
		return stateWiseCities;
	}

	@GetMapping("/show-cities-only")
	public List<String> showCitiesList(@RequestParam("mstate") String state) {

		Map<String, List<String>> stateWiseCities = new HashMap<>();

		stateWiseCities.put("KA", Arrays.asList("BGLR", "MGLR", "MYSR"));
		stateWiseCities.put("TL", Arrays.asList("HYD", "NZBD", "SDPET"));
		stateWiseCities.put("AP", Arrays.asList("VZM", "SLR", "VZG"));
	//	stateWiseCities.put("other", Arrays.asList("no cities available"));
		
		return stateWiseCities.getOrDefault(state, Arrays.asList("no cities available"));

		/*
		 * if (stateWiseCities.containsKey(state)) return stateWiseCities.get(state);
		 * else return stateWiseCities.get("other");
		 */	}
	
	@GetMapping("/show-states-only")
	public Set<String> showStatesList() {

		Map<String, List<String>> stateWiseCities = new HashMap<>();

		stateWiseCities.put("KA", Arrays.asList("BGLR", "MGLR", "MYSR"));
		stateWiseCities.put("TL", Arrays.asList("HYD", "NZBD", "SDPET"));
		stateWiseCities.put("AP", Arrays.asList("VZM", "SLR", "VZG"));
		stateWiseCities.put("other", Arrays.asList("no cities available"));

		return stateWiseCities.keySet();
	}

}
