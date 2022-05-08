package dev.company.faq.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.company.faq.entity.Faq;

public interface FaqRepository extends CrudRepository<Faq, Integer> {
	public List<Faq> findAll();
}
