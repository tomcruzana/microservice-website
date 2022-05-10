package dev.company.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.company.employee.entity.EmployeeRole;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, String>{

}
