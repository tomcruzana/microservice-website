package dev.company.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.customer.entity.Cart;
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
	@Rollback(true)
	public void createCartForCustomerTest() {
		// fail();

		/*
		 * note: always invoke cart stored procedure when creating cx cart since it
		 * contains a custom logic. moreover, this is exclusive for testing only. don't
		 * create a cx cart using this way. refer to RegisteredCustomerAppApplication's
		 * createCustomerWithCartTest for a better way
		 * 
		 */
		cartRepository.createCartForRegisteredCustomer("5", 5);
	}

	@Test
	public void readCartTest() {
		// fail();
		final String cardIdPrefix = "CART";
		String id = cardIdPrefix.concat("5");
		Optional<Cart> cartOptional = cartRepository.findById(id);
		Cart cart = cartOptional.get();
		assertNotNull(cart, "Customer cart found!");
	}

	@Test
	public void readAllCartsTest() {
		// fail();
		List<Cart> all = cartRepository.findAll();
		assertEquals(all.size(), cartRepository.count());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void updateCartTest() {
		// fail();
		final String cardIdPrefix = "CART";
		String id = cardIdPrefix.concat("5");
		Optional<Cart> cartRepositoryOptional = cartRepository.findById(id);
		Cart cart = cartRepositoryOptional.get();

		// you may add more fields to update here
		cart.setId(cardIdPrefix + "6");
		cartRepository.save(cart);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void deleteCartTest() {
		// fail();
		final String cardIdPrefix = "CART";
		String id = cardIdPrefix.concat("5");
		cartRepository.deleteById(id);
	}
}
