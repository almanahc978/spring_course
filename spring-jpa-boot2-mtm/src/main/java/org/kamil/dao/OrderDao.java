package org.kamil.dao;

import javax.transaction.Transactional;

import org.kamil.model.Order;
import org.kamil.model.Product;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {

	public void addProductsToOrder(Long orderId, Product... products) {
		Order order = get(orderId);
		if (order != null) {
			for (Product product : products) {
				order.getProducts().add(product);
			}
		}
	}
}
