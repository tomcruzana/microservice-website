package dev.company.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.company.customer.entity.CustomerEmail;

@RepositoryRestResource(path="customer-emails")
public interface CustomerEmailRepository extends CrudRepository<CustomerEmail, Integer> {

	public Integer findTotalCount();
}
