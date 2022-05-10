package dev.company.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.company.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
