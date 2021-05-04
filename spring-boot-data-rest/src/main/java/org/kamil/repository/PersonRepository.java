package org.kamil.repository;

import java.util.List;

import org.kamil.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "people", collectionResourceRel = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

	@RestResource(exported = false) /*blokuje zasob metodzie GET*/
	List<Person> findAllById(Long id);
}
