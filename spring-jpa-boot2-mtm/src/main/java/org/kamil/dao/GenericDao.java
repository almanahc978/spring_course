package org.kamil.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.lang.reflect.ParameterizedType;

@Transactional
public abstract class GenericDao<T, K> {

	@PersistenceContext
	private EntityManager em;
	private Class<T> type;

	@SuppressWarnings("unchecked")
	GenericDao() {
		type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void save(T entity) {
		em.persist(entity);
	}

	public T get(K key) {
		return em.find(type, key);
	}
	
	public void remove(T entity) {
		T managedEntity = em.merge(entity);
		em.remove(managedEntity);
	}
}
