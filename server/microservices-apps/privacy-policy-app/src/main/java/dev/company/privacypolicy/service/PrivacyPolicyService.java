package dev.company.privacypolicy.service;

import dev.company.privacypolicy.dto.PrivacyPolicyDto;
import dev.company.privacypolicy.exception.PrivacyPolicyException;

public interface PrivacyPolicyService {
	public PrivacyPolicyDto getPrivacyPolicy(int id) throws PrivacyPolicyException;
}
