package org.kamil.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity /*mozna zapisac w bd uzywajac JPA*/
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2285323047910258690L;

	@Id /*kazda encja musi miec id*/
	@GeneratedValue /*automatyczne generowanie id*/
	private long id;
	private String isbn;
	private String title;
	private String author;

	Book() {
	}

	public Book(String isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ".title= " + title + ",author= " + author + "]";
	}

}
