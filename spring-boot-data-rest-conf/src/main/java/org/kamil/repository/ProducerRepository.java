package org.kamil.repository;

import org.kamil.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "manufacturers")
public interface ProducerRepository extends JpaRepository<Producer, Long> {

}
