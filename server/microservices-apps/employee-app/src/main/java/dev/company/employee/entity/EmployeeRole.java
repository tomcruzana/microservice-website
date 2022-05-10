package dev.company.employee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee_role")
public class EmployeeRole {

	@Id
	private String name;

	@OneToMany(mappedBy = "employeeRole", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees;

	public EmployeeRole() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
