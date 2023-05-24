package com.bookListApp.util;

import java.util.Arrays;
import java.util.List;

import com.bookListApp.model.Book;

public class BookDetails {
	
	public static List<Book> showBooks() {
		return Arrays.asList(
		 new Book("Java", "kiran",1, 100.00, "edu"),
		new Book("Funway", "krazy",2, 120.00, "comic"),
		 new Book("NodeJS", "kiran",3, 140.00, "edu"),
		new Book("Funskool", "mayee",4, 110.00, "comic"),
		new Book("Cookbook", "kk",5, 130.00, "cooking"));
	}

}
