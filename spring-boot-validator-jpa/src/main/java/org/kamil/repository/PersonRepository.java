package org.kamil.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.kamil.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class PersonRepository {

	private EntityManager em;

	@Autowired
	public PersonRepository(EntityManager em) {
		this.em = em;
	}

	public void add(Person person) {
		em.persist(person);
	}
}
