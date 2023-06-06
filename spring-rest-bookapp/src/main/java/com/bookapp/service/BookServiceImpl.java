package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	BookDetails details;


	@Override
	public List<Book> getAll() {
		return details.showBooks();
	}

	@Override
	public List<Book> getByAuthorStarting(String author) {
		return details.showBooks()
				.stream()
				.filter(book -> book.getAuthor().startsWith(author))
				.sorted((book1, book2) -> (book1.getTitle()).compareTo(book2.getTitle()))
				.collect(Collectors.toList());
	}

}
