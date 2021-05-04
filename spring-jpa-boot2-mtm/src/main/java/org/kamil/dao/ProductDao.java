package org.kamil.dao;

import javax.transaction.Transactional;

import org.kamil.model.Product;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {

}
