package dev.company.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import dev.company.customer.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {
	@Procedure(name = "Cart.createCartForRegisteredCustomer")
	void createCartForRegisteredCustomer(@Param("cartId") String cartId, @Param("registeredCustomerId") Integer registeredCustomerId);
}
