package org.kamil.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.kamil.model.Person;
import org.kamil.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*Tworzy nad PersonRepository
 *  dodatkowa warstwe abstarkcji i odpowiada za 
 *  m.in. obsluzenie wyjatkow
 */

@Service
public class PersonService {

	private PersonRepository personRepo;

	@Autowired
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	public void add(Person person) {
		try {
			personRepo.add(person);
		} catch (ConstraintViolationException e) {
			Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
			errors.forEach(err -> System.err
					.println(err.getPropertyPath() + " " + err.getInvalidValue() + " " + err.getMessage()));
		}
	}
}
