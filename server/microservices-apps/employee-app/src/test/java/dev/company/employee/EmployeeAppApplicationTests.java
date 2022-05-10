package dev.company.employee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.employee.entity.Employee;
import dev.company.employee.entity.EmployeeRole;
import dev.company.employee.repository.EmployeeRepository;

@SpringBootTest
class EmployeeAppApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback(false)
	public void createEmployeeTest() {
		// fail();
		Employee employee = new Employee();
		EmployeeRole employeeRole = new EmployeeRole();

		employeeRole.setName("ADMIN");

		employee.setDateHired(new Date());
		employee.setEmailAddress("meiji_wang08@email.com");
		employee.setEmployeeRole(employeeRole);
		// employee.setEnabled(false);
		employee.setFirstName("meiji");
		employee.setLastName("wang");
		employee.setPassword("$2a$12$icJ0IOsBLBB1fYpxl2sje.o4XW1zg/.xprTRKI3ZXRUoYROocDdrK");
		employee.setPhoneNumber("9087656475");
		employee.setUsername("mji08");

		employeeRepository.save(employee);
	}

	@Test
	public void readEmployeeTest() {
		// fail();
		int id = 3;
		Employee employee = employeeRepository.getById(id);
		assertNotNull(employee, "Employee found!");
	}

	@Test
	public void readAllEmployeesTest() {
		// fail();
		List<Employee> employees = employeeRepository.findAll();
		assertNotNull(employees, employees.size() + " Employees found!");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void updateEmployeeTest() {
		// fail();
		int id = 3;
		Employee employee = employeeRepository.getById(id);
		employee.setEnabled(false);
		employeeRepository.save(employee);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void deleteEmployeeTest() {
		// fail();
		int id = 3;
		employeeRepository.deleteById(id);
	}

}
