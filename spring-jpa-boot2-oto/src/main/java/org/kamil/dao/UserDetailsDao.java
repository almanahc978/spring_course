package org.kamil.dao;

import javax.persistence.EntityManager;

import org.kamil.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDao {

	private EntityManager em;

	@Autowired
	public UserDetailsDao(EntityManager em) {
		this.em = em;
	}

	public UserDetails get(Long id) {
		return em.find(UserDetails.class, id);
	}
}
