package org.kamil.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.kamil.model.User;
import org.kamil.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao {

	private EntityManager em;

	@Autowired
	public UserDao(EntityManager em) {
		this.em = em;
	}

	public void save(User user) {
		UserDetails details = user.getDetails();
		if (details != null && details.getId() == null) {
			em.persist(details);
		}
		em.persist(user);
	}

	public User get(Long id) {
		return em.find(User.class, id);
	}

	public void update(User user) {
		UserDetails details = user.getDetails();
		if (details != null) {
			details = em.merge(details);
			user.setDetails(details);
		}
		em.merge(user);
	}

	public void delete(User user) {
		User userToDelete = em.merge(user);
		em.remove(userToDelete.getDetails());
		em.remove(user);
	}
}
