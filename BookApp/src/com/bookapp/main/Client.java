package com.bookapp.main;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Client {
	
	public static void main(String[] args) {
		
		IBookService bookService = new BookServiceImpl();
		Book[] books = bookService.getAllBooks();
		System.out.println("printing all books");
		for(Book book:books)
			System.out.println(book);
		System.out.println();
		
		System.out.println("getting all books by author");
		books = bookService.getByAuthor("kiran");
		for(Book book:books)
			System.out.println(book);
		System.out.println();
		
		System.out.println("getting book by id");
		Book book1 = bookService.getById(5);
		System.out.println(book1);
		System.out.println();
		
		System.out.println("getting all books by category");
		books = bookService.getByCategory("comic");
		for(Book book:books)
			System.out.println(book);
		
	}

}
