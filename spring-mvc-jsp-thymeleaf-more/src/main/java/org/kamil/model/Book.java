package org.kamil.model;

public class Book {

	private String author;
	private String title;
	private double price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String author, String title, double price) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", price=" + price + "]";
	}

}
