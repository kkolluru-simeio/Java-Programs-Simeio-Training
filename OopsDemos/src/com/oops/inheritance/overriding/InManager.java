package com.oops.inheritance.overriding;

public class InManager extends InEmployee{
	
	int teamSize;

	public InManager(String name, double salary, String city, int teamSize) {
		super(name, salary, city);
		this.teamSize = teamSize;
	}

	@Override
	void calcBonus(double amount) {
		
		System.out.println("Manager Bonus is "+ amount*10);
	}
	
	void showHobbies(String... hobbies) {
		System.out.println(this.getName()+ " has these hobbies:");
		for(String hobby:hobbies) {
			System.out.println(hobby);
		}
	}
	
	void teamOuting() {
		if(teamSize > 10)
			System.out.println("Weekend outing to a resort is being planned");
		else if(teamSize > 5 && teamSize < 10)
			System.out.println("One day trip is being planned");
		else
			System.out.println("Team lunch is being planned");
	}
	

}
