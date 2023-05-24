package com.bookListApp.service;

import java.util.List;
import java.util.Optional;

import com.bookListApp.model.Book;

public interface IBookService {
	
	List<Book> getAllBooks();

	List<Book> getByAuthor(String author);
	
	Optional<Book> getById(int bookId);
	
	List<Book> getByCategory(String category);

}
