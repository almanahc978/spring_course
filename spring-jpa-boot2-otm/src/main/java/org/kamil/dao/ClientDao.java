package org.kamil.dao;

import javax.transaction.Transactional;

import org.kamil.model.Client;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {

	@Override
	public Client get(Long key) {
		Client client = super.get(key);
		client.getOrders().size();
		return client;
	}
}
