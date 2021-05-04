package org.kamil.dao;

import javax.transaction.Transactional;

import org.kamil.model.Order;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {

}
