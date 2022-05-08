package dev.company.privacypolicy.repository;

import org.springframework.data.repository.CrudRepository;

import dev.company.privacypolicy.entity.PrivacyPolicy;

public interface PrivacyPolicyRepository extends CrudRepository<PrivacyPolicy, Integer> {

}
