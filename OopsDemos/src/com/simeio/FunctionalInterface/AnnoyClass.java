package com.simeio.FunctionalInterface;

public class AnnoyClass {

	public static void main(String[] args) {

		IGames boardGames = new IGames() {

			@Override
			public void createApps() {
				System.out.println("Board games");
				
			}
			
		};
		
		boardGames.createApps();
		
		IGames cardGames = new IGames() {

			@Override
			public void createApps() {
				System.out.println("Card games");
				
			}
			
		};
		
		cardGames.createApps();

	}

}
