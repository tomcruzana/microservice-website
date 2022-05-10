package dev.company.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.company.employee.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String>{

}
