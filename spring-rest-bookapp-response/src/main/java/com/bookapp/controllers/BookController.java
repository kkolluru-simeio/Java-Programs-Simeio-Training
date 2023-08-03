package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api")
public class BookController {

	@Autowired
	IBookService bookService;

	@PostMapping("/books")
	ResponseEntity<Void> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book added to db");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	}

	@PatchMapping("/books/bookId/{bookId}/price/{price}")
	ResponseEntity<Void>  updateBook(@PathVariable("bookId") int bookId, @PathVariable("price") double price) {
		bookService.updateBook(bookId, price);
		return ResponseEntity.accepted().build();
	}
	
	@PutMapping("/books")
	ResponseEntity<Void>  updateAllBook(@RequestBody Book book) {
		bookService.updateBook(book.getBookId(), book.getPrice());
		return ResponseEntity.accepted().build();
		
	}

	@DeleteMapping("/books/bookId/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/books")
	ResponseEntity<List<Book>> getAll() {
		List<Book> books = bookService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all books");
		headers.add("desc", "books in the database");
		ResponseEntity<List<Book>> responseEntity = new ResponseEntity<List<Book>>(books, headers, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/books/bookId/{bookId}")
	ResponseEntity<Book>  getById(@PathVariable("bookId") int bookId) {
		Book book = bookService.getById(bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning book by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(book);
	}

	@GetMapping("/books/category/{category}")
	ResponseEntity<List<Book>> getByCategory(@PathVariable("category") String category) {
		return ResponseEntity.ok(bookService.getByCategory(category));
	}

	@GetMapping("/books/price/{price}")
	ResponseEntity<List<Book>> getByPriceLessThan(@PathVariable("price") double price) {
		List<Book> books = bookService.getByPriceLessThan(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning books by price");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);
	}

	@GetMapping("/books/category/{category}/title/{title}")
	ResponseEntity<List<Book>> getByTitleContaining(@PathVariable("category") String category, @PathVariable("title") String title) {
		List<Book> books = bookService.getByTitleContaining(category, title);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning books by category and title");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);
	}

	@GetMapping("/books/author")
	ResponseEntity<List<Book>>  getByAuthorStarting(@RequestParam("author") String author) {
		List<Book> books = bookService.getByAuthorStarting(author);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning books by author");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);

	}

}
