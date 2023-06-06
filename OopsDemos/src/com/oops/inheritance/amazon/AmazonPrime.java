package com.oops.inheritance.amazon;

enum Categories {
	MOVIES, TVSERIES, KIDS;
}

public class AmazonPrime extends Amazon {

	Categories categories;

	public AmazonPrime(String userName, double subfee, int durationInMonths) {
		super(userName, subfee, durationInMonths);
		// TODO Auto-generated constructor stub
	}

	void showSubDetails(String type) {
		if (type.equals("prime")) {
			setSubfee(this.getSubfee() - 500);
			System.out.println(this.getSubfee());
			System.out.println(this.getSubfee() + 2);
		} else
			System.out.println(this.getSubfee());
	}

	void showCategories() {
		for(Categories c : Categories.values())
		System.out.println(c);
	}

}
