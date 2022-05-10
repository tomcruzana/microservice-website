package dev.company.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.company.customer.entity.RegisteredCustomer;

public interface RegisteredCustomerRepository extends JpaRepository<RegisteredCustomer, Integer> {

}
