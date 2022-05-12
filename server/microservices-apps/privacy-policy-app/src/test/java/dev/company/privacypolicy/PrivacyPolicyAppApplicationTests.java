package dev.company.privacypolicy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.privacypolicy.dto.PrivacyPolicyDto;
import dev.company.privacypolicy.entity.PrivacyPolicy;
import dev.company.privacypolicy.repository.PrivacyPolicyRepository;
import dev.company.privacypolicy.service.PrivacyPolicyService;

@SpringBootTest
class PrivacyPolicyAppApplicationTests {

	@Autowired
	private PrivacyPolicyService privacyPolicyService;

	@Autowired
	PrivacyPolicyRepository privacyPolicyRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllPrivacyPoliciesTest() {
		// fail();
		Iterable<PrivacyPolicy> all = privacyPolicyRepo.findAll();

		// get total of TermsOfUse instances
		long size = all.spliterator().getExactSizeIfKnown();

		assertEquals(size, 1);
	}

	@Test
	public void getResourceServiceLayerTest() throws Exception {
		// fail();
		int id = 1;
		PrivacyPolicyDto privacyPolicyDto = privacyPolicyService.getPrivacyPolicy(id);
		assertNotNull(privacyPolicyDto, "Resource is not null!");
	}
}
