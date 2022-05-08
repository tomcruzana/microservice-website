package dev.company.termsofuse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.termsofuse.entity.TermsOfUse;
import dev.company.termsofuse.repository.TermsOfUseRepository;

@SpringBootTest
class TermsOfUseAppApplicationTests {

	@Autowired
	TermsOfUseRepository termsOfUseRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void getAllTermsOfUseTest() {
		// fail();
		Iterable<TermsOfUse> all = termsOfUseRepo.findAll();
		
		// get total of TermsOfUse instances
		long size = all.spliterator().getExactSizeIfKnown();
		
		assertEquals(size, 1);
	}
	
}
