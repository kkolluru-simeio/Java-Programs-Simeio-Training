package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookConverter;
import com.bookapp.model.BookDTO;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {
	

	IBookRepository bookRepository;
	
	@Autowired
	BookConverter bookConverter;
	
	public BookServiceImpl(IBookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public void addBook(BookDTO bookDTO) {
		bookRepository.addBook(bookConverter.toEntity(bookDTO));
		
	}

	@Override
	public void updateBook(int bookId, double price) {
		bookRepository.updateBook(bookId, price);
		
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteBook(bookId);
		
	}

	@Override
	public List<BookDTO> getAll() {
		List<Book> bookList = bookRepository.findAll();
		return bookList.stream().map(book -> bookConverter.toDTO(book)).collect(Collectors.toList());
	}

	@Override
	public BookDTO getById(int bookId) throws BookNotFoundException{
		Book book = bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException("Invalid Id"));
		return bookConverter.toDTO(book);
	}

	@Override
	public List<BookDTO> getByCategory(String category) throws BookNotFoundException {
		List<Book> bookList = bookRepository.findByCategory(category);
		if (bookList.isEmpty())
			throw new BookNotFoundException("No books found for category "+category);
		return bookList.stream().map(book -> bookConverter.toDTO(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookDTO> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> bookList = bookRepository.findByPriceLessThan(price);
		if (bookList.isEmpty())
			throw new BookNotFoundException("No books found less than price "+price);
		return bookList.stream().map(book -> bookConverter.toDTO(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookDTO> getByTitleContaining(String category, String title) throws BookNotFoundException{
		List<Book> bookList = bookRepository.findByTitleContaining(category, title);
		if (bookList.isEmpty())
			throw new BookNotFoundException("No books found containing title "+title);
		return bookList.stream().map(book -> bookConverter.toDTO(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookDTO> getByAuthorStarting(String author) throws BookNotFoundException{
		List<Book> bookList = bookRepository.findByAuthorStarting(author);
		if (bookList.isEmpty())
			throw new BookNotFoundException("No books found for author "+author);
		return bookList.stream().map(book -> bookConverter.toDTO(book)).collect(Collectors.toList());
	}
}


