package dev.company.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.company.customer.entity.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

	@Query(value = "SELECT * FROM CART_ITEM INNER JOIN CART ON CART_ITEM.CART_ID = CART.ID WHERE CART_ITEM.CART_ID = :cartId", nativeQuery = true)
	List<CartItem> findAllCartItemsByCartId(@Param("cartId") String cartId);
}
