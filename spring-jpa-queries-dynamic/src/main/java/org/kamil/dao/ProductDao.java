package org.kamil.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.kamil.model.Product;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductDao {

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Product get(Long id) {
		return em.find(Product.class, id);
	}

	public void save(Product product) {
		em.persist(product);
	}

	public List<Product> getAll() {
		TypedQuery<Product> tp = em.createNamedQuery("Product.getAll", Product.class);
		return tp.getResultList();
	}

	public List<Product> getByName(String name) {
		TypedQuery<Product> tp = em.createNamedQuery("Product.getByName", Product.class);
		tp.setParameter("name", name);
		return tp.getResultList();
	}

	public void removeAll() {
		Query query = em.createNamedQuery("Product.removeAll");
		query.executeUpdate();
	}

	public void removeByProducer(String producer) {
		Query query = em.createQuery("DELETE FROM Product p WHERE p.producer = :producer");
		query.setParameter("producer", producer);
		query.executeUpdate();
	}

	public List<Product> customGet(String jpqlQuery) {
		TypedQuery<Product> tp = em.createQuery(jpqlQuery, Product.class);
		return tp.getResultList();
	}
}
