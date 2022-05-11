package dev.company.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.customer.entity.Cart;
import dev.company.customer.entity.CartItem;
import dev.company.customer.repository.CartItemRepository;
import dev.company.customer.repository.CartRepository;

@SpringBootTest
public class CartItemAppApplicationTest {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartItemRepository cartItemRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void addToCartTest() {
		// fail();

		// get an existing cart
		final String cardIdPrefix = "CART";
		String cartId = cardIdPrefix.concat("5");
		Cart cart = cartRepository.getById(cartId);

		int ProductItemId = 2;
		int qty = 1;

		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProductItemId(ProductItemId);
		cartItem.setQuantity(qty);
		cartItemRepository.save(cartItem);

	}

	@Test
	public void readCartItem() {
		// fail();
		int id = 2;

		Optional<CartItem> cartItemOptional = cartItemRepository.findById(id);
		CartItem cartItem = cartItemOptional.get();

		assertNotNull(cartItem, "Customer cart found!");

	}

	@Test
	public void readCartItemByCartId() {
		// fail();
		String cartId = "CART5";
		List<CartItem> all = cartItemRepository.findAllCartItemsByCartId(cartId);
		assertNotNull(all, "Cart items found on " + cartId);
	}

	@Test
	public void readAllCartItemsTest() {
		// fail();
		Iterable<CartItem> all = cartItemRepository.findAll();
		assertEquals(all.spliterator().estimateSize(), cartItemRepository.count());

	}

	@Test
	@Transactional
	@Rollback(true)
	public void updateCartItemTest() {
		// fail();
		int id = 2;

		Optional<CartItem> cartItemOptional = cartItemRepository.findById(id);
		CartItem cartItem = cartItemOptional.get();

		// you may add more fields to update here
		cartItem.setQuantity(3);
		cartItemRepository.save(cartItem);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void deleteCartItemTest() {
		// fail();
		int id = 2;
		cartItemRepository.deleteById(id);
	}
}
