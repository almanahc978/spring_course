package org.kamil.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.kamil.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/cities")
public class CityController {

	private List<City> cities;

	public CityController() {
		cities = Collections.synchronizedList(new ArrayList<City>());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<City> getCity(@RequestParam(defaultValue = "name") String orderBy) {
		List<City> citiesCopy = new ArrayList<>(cities);

		if ("name".equals(orderBy)) {
			citiesCopy.sort(Comparator.comparing(City::getName));
		} else if ("population".equals(orderBy)) {
			citiesCopy.sort(Comparator.comparing(City::getPopulation));
		}

		return citiesCopy;
	}

	@GetMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable int id) {
		if (id > cities.size() || id < 0) {
			return ResponseEntity.notFound().build();
		}
		City city = cities.get(id);
		return ResponseEntity.ok(city);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCity(@RequestBody City city) {
		if (!cities.contains(city)) {
			cities.add(city);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
					.buildAndExpand(cities.size() - 1).toUri();
			return ResponseEntity.created(location).body(city);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
