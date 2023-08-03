package com.bookapp.model;

import org.springframework.stereotype.Component;

@Component
public class BookConverter {
	
	public Book toEntity(BookDTO bookDTO) {
		
		Book book = new Book();
		book.setBookId(bookDTO.getBookId());
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setCategory(bookDTO.getCategory());
		book.setPrice(bookDTO.getPrice());
		return book;
	}
	
	public BookDTO toDTO(Book book) {
		
		BookDTO bookDTO = new BookDTO();
		bookDTO.setBookId(book.getBookId());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setPrice(book.getPrice());
		return bookDTO;
	}

}
