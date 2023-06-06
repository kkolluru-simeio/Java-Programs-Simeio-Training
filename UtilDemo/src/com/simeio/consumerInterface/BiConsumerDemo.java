package com.simeio.consumerInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerDemo {

	public static void main(String[] args) {
		

		
		BiConsumer<String, String> biConsumer = (greet, name) -> System.out.println(greet.concat(name));
		String greet = "Hello ";
		String name = "kiran";
		biConsumer.accept(greet, name);
		
		BiConsumer<String, Integer> biConsumer1 = (eName, id) ->  {
			if(id>5)
				System.out.println("Welcome "+ eName);
			else
				System.out.println("Wrong user " + eName);
		};
		biConsumer1.accept("kiran", 3);
		biConsumer1.accept("kk", 7);
		
	}
}
