package com.simeio.ex;

public class MultiCatch {

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
		} catch (ArithmeticException | NumberFormatException  | ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("please enter values other than zero");
			System.out.println(e);
		} catch(Exception e) {
			System.out.println("other exception");
			System.out.println(e);
		}
		System.out.println("work done");
	}

}
