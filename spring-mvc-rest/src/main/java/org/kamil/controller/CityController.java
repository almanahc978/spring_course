package org.kamil.controller;

import org.kamil.model.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	@RequestMapping("/city")
	public City getCity() {
		return new City("Bialystok", 300000);
	}
}
