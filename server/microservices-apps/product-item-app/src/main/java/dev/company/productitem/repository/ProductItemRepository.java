package dev.company.productitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.company.productitem.entity.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {

}
