package org.kamil;

import org.kamil.dao.BookDao;
import org.kamil.dao.BookDaoImpl;
import org.kamil.model.Book;

public class Main {

	public static void main(String[] args) {
		Book book = new Book("123456789", "Wilk z Wall Street", "Jordan Belfort");
		BookDao bookDao = new BookDaoImpl();
		bookDao.save(book);
		System.out.println("Book saved");
		Book book2 = bookDao.get(1L);
		System.out.println(book2);

		bookDao.cleanUp();
	}
}
