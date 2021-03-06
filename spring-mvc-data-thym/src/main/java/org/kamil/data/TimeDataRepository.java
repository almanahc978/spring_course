package org.kamil.data;

import org.kamil.model.TimeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeDataRepository extends JpaRepository<TimeData, Long>{

}
