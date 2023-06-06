package com.oops.inheritance.abstraction;

public class Main {

	public static void main(String[] args) {


		Bank bank1 = new Branch1(8,7,9);
		System.out.println("Branch1 loan percentages");
		bank1.carLoan();
		bank1.homeLoan();
		bank1.eduLoan();
		
		
		Bank bank2 = new SubBranch(8,7,9);
		System.out.println("SubBranch loan percentages");
		bank2.carLoan();
		bank2.homeLoan();
		bank2.eduLoan();

		Branch2 branch = (Branch2) bank2;
		
		branch.loanPayment();
		
		SubBranch subBranch = (SubBranch)bank2;
		
		subBranch.setName("Bolanden");
		
		subBranch.showSubBranchName();

	}

}
