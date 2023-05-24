package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public Book[] getAllBooks() {
		return BookDetails.showBooks();
	}

	@Override
	public Book[] getByAuthor(String author) {
		int count = 0;
		Book[] booksByAuthor = BookDetails.showBooks();
		for(Book book:booksByAuthor) {
			if(book.getAuthor().equals(author))
				count++;
		}
		Book[] matchingBooks = new Book[count];
		count = 0;
		for(Book book:booksByAuthor) {
			if(book.getAuthor().equals(author))
				matchingBooks[count++] = book;
		}
		return matchingBooks;
	}

	@Override
	public Book getById(int bookId) {
		
		
		Book[] books = BookDetails.showBooks();
		for(Book book:books) {
			if(book.getBookId().equals(bookId))
				return book;
		}
		return null;
	}

	@Override
	public Book[] getByCategory(String category) {
		int count = 0;
		Book[] booksByCategory = BookDetails.showBooks();
		for(Book book:booksByCategory) {
			if(book.getCategory().equals(category))
				count++;
		}
		Book[] matchingBooks = new Book[count];
		count = 0;
		for(Book book:booksByCategory) {
			if(book.getCategory().equals(category))
				matchingBooks[count++] = book;
		}
		return matchingBooks;
	}
	
	

}
