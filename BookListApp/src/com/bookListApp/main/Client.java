package com.bookListApp.main;

import java.util.List;
import java.util.Optional;

import com.bookListApp.model.Book;
import com.bookListApp.service.BookServiceImpl;
import com.bookListApp.service.IBookService;

public class Client {
	
	public static void main(String[] args) {
		
		IBookService bookService = new BookServiceImpl();
		List<Book> books = bookService.getAllBooks();
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
		Optional<Book> bookById = bookService.getById(5);
		System.out.println(bookById);
		System.out.println();
		
		System.out.println("getting all books by category");
		books = bookService.getByCategory("comic");
		for(Book book:books)
			System.out.println(book);
		
	}

}
