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
import com.bookapp.model.BookDTO;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api")
public class BookController {

	@Autowired
	IBookService bookService;

	@PostMapping("/books")
	ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
		bookService.addBook(bookDTO);
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
	ResponseEntity<List<BookDTO>> getAll() {
		List<BookDTO> bookDTOList = bookService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all books");
		headers.add("desc", "books in the database");
		ResponseEntity<List<BookDTO>> responseEntity = new ResponseEntity<List<BookDTO>>(bookDTOList, headers, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/books/bookId/{bookId}")
	ResponseEntity<BookDTO>  getById(@PathVariable("bookId") int bookId) {
		BookDTO bookDTO = bookService.getById(bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning book by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookDTO);
	}

	@GetMapping("/books/category/{category}")
	ResponseEntity<List<BookDTO>> getByCategory(@PathVariable("category") String category) {
		return ResponseEntity.ok(bookService.getByCategory(category));
	}

	@GetMapping("/books/price/{price}")
	ResponseEntity<List<BookDTO>> getByPriceLessThan(@PathVariable("price") double price) {
		List<BookDTO> bookDTOList = bookService.getByPriceLessThan(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning books by price");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookDTOList);
	}

	@GetMapping("/books/category/{category}/title/{title}")
	ResponseEntity<List<BookDTO>> getByTitleContaining(@PathVariable("category") String category, @PathVariable("title") String title) {
		List<BookDTO> bookDTOList = bookService.getByTitleContaining(category, title);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning books by category and title");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookDTOList);
	}

	@GetMapping("/books/author")
	ResponseEntity<List<BookDTO>>  getByAuthorStarting(@RequestParam("author") String author) {
		List<BookDTO> bookDTOList = bookService.getByAuthorStarting(author);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning books by author");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookDTOList);

	}

}
