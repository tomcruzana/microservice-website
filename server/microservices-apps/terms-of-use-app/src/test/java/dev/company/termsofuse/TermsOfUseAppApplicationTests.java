package dev.company.termsofuse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.termsofuse.dto.TermsOfUseDto;
import dev.company.termsofuse.entity.TermsOfUse;
import dev.company.termsofuse.repository.TermsOfUseRepository;
import dev.company.termsofuse.service.TermsOfUseService;

@SpringBootTest
class TermsOfUseAppApplicationTests {
	@Autowired
	private TermsOfUseService termsOfUseService;

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
	
	@Test
	public void getResourceServiceLayerTest() throws Exception {
		// fail();
		int id = 1;
		TermsOfUseDto termsOfUseDto = termsOfUseService.getTermsOfUse(id);
		assertNotNull(termsOfUseDto, "Resource is not null!");
	}
	
}
