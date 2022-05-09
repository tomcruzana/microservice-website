package dev.company.productitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.company.productitem.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

}
