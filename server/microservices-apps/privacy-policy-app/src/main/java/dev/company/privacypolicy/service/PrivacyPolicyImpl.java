package dev.company.privacypolicy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import dev.company.privacypolicy.dto.PrivacyPolicyDto;
import dev.company.privacypolicy.entity.PrivacyPolicy;
import dev.company.privacypolicy.exception.PrivacyPolicyException;
import dev.company.privacypolicy.repository.PrivacyPolicyRepository;

@Service
public class PrivacyPolicyImpl implements PrivacyPolicyService {

	@Autowired
	PrivacyPolicyRepository privacyPolicyRepo;

	@Autowired
	private Environment environment;
	
	@Override
	public PrivacyPolicyDto getPrivacyPolicy(int id) throws PrivacyPolicyException {
		Optional<PrivacyPolicy> privacyPolicyOptional = privacyPolicyRepo.findById(id);
		PrivacyPolicy privacyPolicy = privacyPolicyOptional
				.orElseThrow(() -> new PrivacyPolicyException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));

		PrivacyPolicyDto privacyPolicyDto = new PrivacyPolicyDto();
		privacyPolicyDto.setId(privacyPolicy.getId());
		privacyPolicyDto.setDateCreated(privacyPolicy.getDateCreated());
		privacyPolicyDto.setTitle(privacyPolicy.getTitle());
		privacyPolicyDto.setDescription(privacyPolicy.getDescription());
		return privacyPolicyDto;
	}

}
