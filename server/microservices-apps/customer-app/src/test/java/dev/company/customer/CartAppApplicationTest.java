package dev.company.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.customer.repository.CartRepository;

@SpringBootTest
class CartAppApplicationTest {

	@Autowired
	CartRepository cartRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback(false)
	public void createCartForCustomerTest() {
		// fail();

		// invoke cart stored procedure
		cartRepository.createCartForRegisteredCustomer("3", 2);
	}

}
