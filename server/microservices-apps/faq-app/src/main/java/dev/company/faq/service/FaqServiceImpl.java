package dev.company.faq.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import dev.company.faq.dto.FaqDto;
import dev.company.faq.entity.Faq;
import dev.company.faq.exception.FaqException;
import dev.company.faq.repository.FaqRepository;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	FaqRepository faqRepository;

	@Autowired
	private Environment environment;

	@Override
	public List<FaqDto> getAllFaqs() throws FaqException {
		List<Faq> faqList = faqRepository.findAll();
		if (faqList.isEmpty()) {
			throw new FaqException(environment.getProperty("Domain.RESOURCE_NOT_FOUND"));
		}

		List<FaqDto> faqDtoList = new ArrayList<>();

		faqList.forEach(faq -> {
			FaqDto faqDto = new FaqDto();
			faqDto.setId(faq.getId());
			faqDto.setDateCreated(faq.getDateCreated());
			faqDto.setQuestion(faq.getQuestion());
			faqDto.setAnswer(faq.getAnswer());

			faqDtoList.add(faqDto);
		});
		return faqDtoList;
	}

	@Override
	public FaqDto getFaqById(int id) throws FaqException {
		Optional<Faq> faqOptional = faqRepository.findById(id);

		Faq faq = faqOptional.orElseThrow(() -> new FaqException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));
		FaqDto faqDto = new FaqDto();
		faqDto.setId(faq.getId());
		faqDto.setDateCreated(faq.getDateCreated());
		faqDto.setAnswer(faq.getAnswer());
		faqDto.setQuestion(faq.getQuestion());
		return faqDto;
	}

}
