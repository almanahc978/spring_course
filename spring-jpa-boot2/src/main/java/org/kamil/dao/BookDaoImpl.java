package org.kamil.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.kamil.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@PersistenceContext
	private EntityManager entityManager;

	public BookDaoImpl() {

	}

	@Override
	@Transactional
	public void save(Book book) {
		entityManager.persist(book);
	}

	@Override
	public Book get(Long id) {
		return entityManager.find(Book.class, id);
	}

	@Override
	@Transactional
	public void update(Book book) {
		/* przekazany obiekt book musi miec ustawiony klucz glowny
		 * na jego podstawie najstepuje scalenie danych
		 *  */
		Book find = entityManager.find(Book.class, book.getId());
		
		if(find!=null) {
			find.setTitle(book.getTitle());
			find.setIsbn(book.getIsbn());
			find.setAuthor(book.getAuthor());
		}
	}

	@Override
	@Transactional
	public void remove(Long bookId) {
		Book objToRemove = entityManager.find(Book.class, bookId);
		entityManager.remove(objToRemove);
	}
	


}
