package org.kamil.controller.rest;

import java.util.Comparator;
import java.util.List;

import org.kamil.model.City;
import org.kamil.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityControllerRest {

	private CityRepository cityRepo;

	@Autowired
	public CityControllerRest(CityRepository cityRepo) {
		this.cityRepo = cityRepo;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<City> getCites(@RequestParam(defaultValue = "name") String orderBy) {
		List<City> cities = cityRepo.findAll();

		if ("name".equals(orderBy)) {
			cities.sort(Comparator.comparing(City::getName));
		} else if ("population".equals(orderBy)) {
			cities.sort(Comparator.comparing(City::getPopulation));
		}

		return cities;
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> getCity(@PathVariable long id) {
		return cityRepo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCity(@RequestBody City city) {
		cityRepo.save(city);
	}
}
