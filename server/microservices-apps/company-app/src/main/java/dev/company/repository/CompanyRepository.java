package dev.company.repository;

import org.springframework.data.repository.CrudRepository;

import dev.company.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer>{

}
