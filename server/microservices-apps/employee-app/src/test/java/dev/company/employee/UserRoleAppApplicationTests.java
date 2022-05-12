package dev.company.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.employee.entity.UserRole;
import dev.company.employee.repository.UserRoleRepository;

@SpringBootTest
class UserRoleAppApplicationTests {

	@Autowired
	UserRoleRepository userRoleRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void createUserRoleTest() {
		// fail();
		UserRole userRole = new UserRole();
		String roleName = "dba".toUpperCase();
		userRole.setName(roleName);
		userRoleRepository.save(userRole);
	}

}
