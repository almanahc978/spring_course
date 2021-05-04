package org.kamil.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4117661740041409973L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private Long id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "order_products", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "id_product") })
	private List<Product> products = new ArrayList<>();

	@Column(name = "details", length = 512)
	private String orderDetails;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Order() {

	}

	public Order(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDetails=" + orderDetails + ", client=" + client.getFirstName() + " "
				+ client.getLastName() + products.size() + ",\n products=" + products + "]";
	}
}
