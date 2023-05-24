package com.bookapp.util;

import com.bookapp.model.Book;

public class BookDetails {
	
	public static Book[] showBooks() {
		Book[] book = new Book[5];
		book[0] = new Book("Java", "kiran",1, 100.00, "edu");
		book[1] = new Book("Funway", "krazy",2, 120.00, "comic");
		book[2] = new Book("NodeJS", "kiran",3, 140.00, "edu");
		book[3] = new Book("Funskool", "mayee",4, 110.00, "comic");
		book[4] = new Book("Cookbook", "kk",5, 130.00, "cooking");
		return book;
	}

}
