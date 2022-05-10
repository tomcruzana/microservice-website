package dev.company.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.company.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
