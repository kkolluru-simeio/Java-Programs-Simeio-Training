package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
public class BookAppController {
	
	@Autowired
	IBookService bookService;
	@GetMapping("/books")
	public List<Book> getAll() {
		
		return bookService.getAll();
	}
	
	@GetMapping("/books/author/")
	public List<Book> getByAuthorStarting(@RequestParam("author") String author) {
		return bookService.getByAuthorStarting(author);
	}


}
