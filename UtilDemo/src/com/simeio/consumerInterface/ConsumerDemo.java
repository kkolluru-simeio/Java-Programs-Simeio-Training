package com.simeio.consumerInterface;

import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		
		Consumer<String> consumer = (str) -> System.out.println(str.toUpperCase());
		
		consumer.accept("kiran");
		
		Consumer<Integer> consumer1 = (i) -> System.out.println("square of " + i + (i*i));
		
		consumer1.accept(3);
		
		
	}
}
