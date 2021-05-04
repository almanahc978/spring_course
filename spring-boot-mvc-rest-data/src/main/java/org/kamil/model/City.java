package org.kamil.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4801260125073438290L;

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int population;

	public City() {
		
	}

	public City(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	public long getId() {
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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
