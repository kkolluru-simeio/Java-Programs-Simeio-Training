package com.oops.inheritance.overriding;

public class Main {

	public static void main(String[] args) {
		InEmployee employee1 = new InManager("kiran", 1115435.60, "kibo", 10);
		InEmployee employee2 = new InDeveloper("katya", 4552245.60, "bglr", "IAM");
		
		employee1.calcBonus(500);
		
		InManager manager = (InManager) employee1;
		manager.showHobbies("tt","tv");
		
		employee2.calcBonus(400);
		InDeveloper developer = (InDeveloper) employee2;
		developer.showAssignedProject();
	}

}
