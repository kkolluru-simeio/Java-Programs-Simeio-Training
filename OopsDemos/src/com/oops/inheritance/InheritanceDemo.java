package com.oops.inheritance;

public class InheritanceDemo {
	
	public static void main(String[] args) {
		FourWheeler fourWheeler = new FourWheeler("honda","lmv", 2021);
		fourWheeler.print();
		Car car = new Car("hero","lmv", 2023, "cat");
		car.print();
	}

}
