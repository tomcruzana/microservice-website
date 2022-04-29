package dev.company.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.company.customer.entity.Customer;

@RepositoryRestResource(path="customers")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
