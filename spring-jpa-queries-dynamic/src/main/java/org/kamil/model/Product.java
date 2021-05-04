package org.kamil.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Product.getAll", query = "SELECT p FROM Product p"),
	@NamedQuery(name = "Product.getByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
		@NamedQuery(name = "Product.removeAll", query = "DELETE FROM Product p") }) /*
																			 * static queries, tlumczone tylko raz na
																			 * jezyk SQL, moga zwiekszyc wydajnosc
																			 */
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8657069181956677644L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String producer;

	private Double price;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String producer, Double price) {
		super();
		this.name = name;
		this.producer = producer;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", producer=" + producer + ", price=" + price + "]";
	}

}
