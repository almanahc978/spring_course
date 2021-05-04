package org.kamil.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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

	@Column(nullable = false)
	private String product;

	@Column(name = "details", length = 512)
	private String orderDetails;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Order() {
	}

	public Order(String product, String orderDetails) {
		super();
		this.product = product;
		this.orderDetails = orderDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", orderDetails=" + orderDetails + ", "
				+ client.getFirstName() + " " + client.getLastName() + "]";
	}

}
