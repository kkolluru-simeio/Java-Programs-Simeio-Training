package com.simeio.ref;

public class Main {

	public static void main(String[] args) {


		Greeter ref = (name) -> {
			System.out.println("hi " + name);
		};
		
		ref.greetUser("kiran");
		
		Greeter ref1 = UserDetails::welcomeUser;
		
		ref1.greetUser("katya");
		
		UserDetails userDetails = new UserDetails();
		Greeter ref2 = userDetails::print;
		
		ref1.greetUser("mayee");
	}

}
