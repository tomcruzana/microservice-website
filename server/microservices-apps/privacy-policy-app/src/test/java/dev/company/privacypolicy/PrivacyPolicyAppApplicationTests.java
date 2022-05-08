package dev.company.privacypolicy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.privacypolicy.entity.PrivacyPolicy;
import dev.company.privacypolicy.repository.PrivacyPolicyRepository;

@SpringBootTest
class PrivacyPolicyAppApplicationTests {

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
}
