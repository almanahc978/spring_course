package org.kamil.dao;

import org.kamil.model.Book;

public interface BookDao {

	public void save(Book book);
	public Book get(Long id);
}
