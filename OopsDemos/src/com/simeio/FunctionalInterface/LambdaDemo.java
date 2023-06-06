package com.simeio.FunctionalInterface;

interface IGreet {
	
	String greetMessage(String userName);

}

interface IGreetYou {
	
	void greetMessage(String userName);

}

public class LambdaDemo {
	
	public static void main(String[] args) {
		IGreet greet = (name) ->  {
			return "Welcome " + name;
		};
		
	System.out.println(greet.greetMessage("kiran"));
		
		IGreetYou greet1 = (name) -> System.out.println("Bye bye " + name);
		
		greet1.greetMessage("kiran");
		
	}
	
}