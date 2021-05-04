package org.kamil.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.kamil.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	
	@PersistenceUnit
	private EntityManagerFactory emFactory;
	
	public BookDaoImpl() {
		
	}

	@Override
	public void save(Book book) {
		EntityManager entityManager = emFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(book);
		tx.commit();
		entityManager.close();
	}

	@Override
	public Book get(Long id) {
		EntityManager entityManager = emFactory.createEntityManager();
		Book book = entityManager.find(Book.class, id);
		return book;
	}


}
