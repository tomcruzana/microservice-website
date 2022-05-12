package dev.company.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.customer.entity.RegisteredCustomer;
import dev.company.customer.repository.CartRepository;
import dev.company.customer.repository.RegisteredCustomerRepository;

@SpringBootTest
public class RegisteredCustomerAppApplication {

	@Autowired
	RegisteredCustomerRepository registeredCustomerRepo;

	@Autowired
	CartRepository cartRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void createCustomerWithCartTest() {
		// fail();
		RegisteredCustomer registeredCustomer = new RegisteredCustomer();
		registeredCustomer.setFirstName("john");
		registeredCustomer.setLastName("smith");
		registeredCustomer.setDateCreated(new Date());
		registeredCustomer.setEmailAddress("john.smith@email.com");
		registeredCustomer.setEnabled(false);
		registeredCustomer.setPassword("$2a$12$PTMSi3U.cqwVs5FZsSYZi.16U14hJZIBekvv5Q//3Jt7ra2cp4EN.");
		registeredCustomer.setPhoneNumber("8976541234");
		registeredCustomer.setUsername("smith_john64");

		registeredCustomerRepo.save(registeredCustomer);

		// find newly created cx & invoke Cart's stored procedure for cx cart creation
		Optional<RegisteredCustomer> newlyRegisteredCustomerOptional = registeredCustomerRepo
				.findByUsername(registeredCustomer.getUsername());
		int id = newlyRegisteredCustomerOptional.get().getId();
		cartRepository.createCartForRegisteredCustomer(String.valueOf(id), id);

	}

	@Test
	public void readCustomerTest() {
		// fail();
		int id = 5;
		Optional<RegisteredCustomer> registeredCustomerOptional = registeredCustomerRepo.findById(id);
		RegisteredCustomer registeredCustomer = registeredCustomerOptional.get();
		assertNotNull(registeredCustomer, "Registered customer found!");
	}

	@Test
	public void readAllCustomersTest() {
		// fail();
		List<RegisteredCustomer> all = registeredCustomerRepo.findAll();
		assertEquals(all.size(), registeredCustomerRepo.count());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void updateCustomerTest() {
		// fail();
		int id = 5;
		Optional<RegisteredCustomer> registeredCustomerOptional = registeredCustomerRepo.findById(id);
		RegisteredCustomer registeredCustomer = registeredCustomerOptional.get();

		// you may add more fields to update here
		registeredCustomer.setEnabled(false);
		registeredCustomerRepo.save(registeredCustomer);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void deleteCustomerTest() {
		// fail();
		int id = 5;
		registeredCustomerRepo.deleteById(id);
	}
}
