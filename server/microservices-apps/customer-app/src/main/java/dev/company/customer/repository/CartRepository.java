package dev.company.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.company.customer.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {

}
