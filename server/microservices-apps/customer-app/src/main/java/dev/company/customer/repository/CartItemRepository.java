package dev.company.customer.repository;

import org.springframework.data.repository.CrudRepository;

import dev.company.customer.entity.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

}
