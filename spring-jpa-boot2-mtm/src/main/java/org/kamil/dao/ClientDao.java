package org.kamil.dao;

import javax.transaction.Transactional;

import org.kamil.model.Client;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {

	public void removeAllOrders(Client client) {
		Client managedClient = get(client.getId());
		managedClient.getOrders().clear();
	}
}
