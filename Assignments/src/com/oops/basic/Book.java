package com.oops.basic;

public class Book {
	
	private String title;
	private String author;
	private double price;
	private String category;
	
	public Book(String title, String author, double price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;

	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void getDetails() {
		System.out.println("title is " + title);
		System.out.println("author is " + author);
		this.category = (price > 500) ? "premium" : "standard book";
			System.out.println("category is " + category);
		}
	

}
