package dev.company.guestemail.repository;

import org.springframework.data.repository.CrudRepository;

import dev.company.guestemail.entity.GuestEmail;

public interface GuestEmailRepository extends CrudRepository<GuestEmail, String> {
	public Integer findTotal();
}
