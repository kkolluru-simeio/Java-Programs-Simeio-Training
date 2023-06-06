package com.simeio.basics;

public class Book {
	private String title;
	private int bookId;
	private String author;
	private double price;
	
	public Book() {
		super();
	}

	public Book(String title, int bookId, String author, double price) {
		super();
		this.title = title;
		this.bookId = bookId;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "book [title=" + title + ", bookId=" + bookId + ", author=" + author + ", price=" + price + "]";
	}
	
	

}
