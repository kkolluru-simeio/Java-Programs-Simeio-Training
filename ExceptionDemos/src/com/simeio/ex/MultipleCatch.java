package com.simeio.ex;

public class MultipleCatch {

	public static void main(String[] args) {

		System.out.println("Welcome");
		try {
			String val = args[0];
			System.out.println("Value got");
			int num = Integer.parseInt(val);
			System.out.println("Num " + num);
			int result = 100 / num;
			System.out.println(result);
			int marks[] = null;
			System.out.println(marks[0]);
		} catch (ArithmeticException e) {
			System.out.println("please enter values other than zero");
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("please enter numbers and not letters");
			System.out.println(e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("please enter a value");
			System.out.println(e);
		} catch(RuntimeException e) {
			System.out.println("other exception");
			System.out.println(e);
		}
		System.out.println("work done");
	}

}
