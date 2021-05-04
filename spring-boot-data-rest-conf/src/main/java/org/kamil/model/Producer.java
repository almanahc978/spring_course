package org.kamil.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Producer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4941273727529533049L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String country;
	private double totallincome;

	@OneToMany(mappedBy = "producer")
	private List<Product> products;

	public Producer() {

	}

	public Producer(String name, String country, double totallincome) {
		super();
		this.name = name;
		this.country = country;
		this.totallincome = totallincome;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getTotallincome() {
		return totallincome;
	}

	public void setTotallincome(double totallincome) {
		this.totallincome = totallincome;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
