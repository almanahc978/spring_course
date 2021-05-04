package org.kamil.repository;

import java.util.List;

import org.kamil.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(name = "Employee.findByLastNameAndSalary")
	List<Employee> findByLastNameAndSalary(@Param("lastName") String lastName, @Param("salary") double salary);

	@Query("SELECT e.lastName FROM Employee e WHERE e.salary>=:salary ORDER BY e.lastName ASC")
	List<String> namesForSalaryAsc(@Param("salary") double salary);
}
