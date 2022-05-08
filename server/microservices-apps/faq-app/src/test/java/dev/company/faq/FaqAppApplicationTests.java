package dev.company.faq;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.faq.entity.Faq;
import dev.company.faq.repository.FaqRepository;

@SpringBootTest
class FaqAppApplicationTests {

	@Autowired
	FaqRepository faqRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllFaqs() {
		// fail();
		Iterable<Faq> all = faqRepository.findAll();

		// get total of TermsOfUse instances
		long size = all.spliterator().getExactSizeIfKnown();

		// perform SQL aggregate count query
		assertEquals(size, faqRepository.count());
	}

}
