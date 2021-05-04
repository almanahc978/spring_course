package org.kamil.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity /* mozna zapisac w bd uzywajac JPA */
@Table(name = "books")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2285323047910258690L;

	@Id /* kazda encja musi miec id */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* automatyczne generowanie id */
	@Column(name = "book_id")
	private long id;
	@Column(nullable = false, unique = true)
	private String isbn;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
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
	
	@PrePersist
	public void prePersist() {
		System.out.println("Zapis obiektu " + this);
	}
	
	@PostPersist
	public void postPersist() {
		System.out.println("Zapisano obiekt " + this);
	}

}
