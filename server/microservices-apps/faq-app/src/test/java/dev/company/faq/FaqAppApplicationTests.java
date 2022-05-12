package dev.company.faq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.faq.dto.FaqDto;
import dev.company.faq.entity.Faq;
import dev.company.faq.exception.FaqException;
import dev.company.faq.repository.FaqRepository;
import dev.company.faq.service.FaqService;

@SpringBootTest
class FaqAppApplicationTests {

	@Autowired
	private FaqService faqService;

	@Autowired
	FaqRepository faqRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllFaqsTest() {
		// fail();
		Iterable<Faq> all = faqRepository.findAll();

		// get total of TermsOfUse instances
		long size = all.spliterator().getExactSizeIfKnown();

		// perform SQL aggregate count query
		assertEquals(size, faqRepository.count());
	}

	@Test
	public void getFaqByIdServiceLayerTest() throws FaqException {
		// fail();
		int id = 1;
		FaqDto faqDto = faqService.getFaqById(id);
		assertNotNull(faqDto, "Resource is not null!");
	}

	@Test
	public void getAllFaqsServiceLayerTest() throws Exception {
		// fail();
		List<FaqDto> allFaqs = faqService.getAllFaqs();
		assertNotNull(allFaqs, "Resource is not null!");
	}

}
