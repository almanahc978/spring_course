package org.kamil.model;

import javax.validation.constraints.Min;

import org.kamil.constraint.Divided;

public class NumberBean {

	@Divided(by = 3)
	@Min(value = 3)
	private Integer number;

	public NumberBean() {

	}

	public NumberBean(@Min(3) Integer number) {
		super();
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
