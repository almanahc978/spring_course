package org.kamil.repository;

import org.kamil.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	UserRole findByRole(String role);
}
