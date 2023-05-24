package com.bookListApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookListApp.model.Book;
import com.bookListApp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> getAllBooks() {
		return BookDetails.showBooks();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		
		return BookDetails.showBooks().stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
	}

	@Override
	public Optional<Book> getById(int bookId) {
		
		return BookDetails.showBooks().stream().filter(book -> book.getBookId()== bookId).findFirst();
	}

	@Override
	public List<Book> getByCategory(String category) {
		// TODO Auto-generated method stub
		 return BookDetails.showBooks().stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());

	}


	
	

}
