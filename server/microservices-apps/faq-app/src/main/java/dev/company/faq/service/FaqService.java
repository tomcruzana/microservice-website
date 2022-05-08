package dev.company.faq.service;

import java.util.List;

import dev.company.faq.dto.FaqDto;
import dev.company.faq.exception.FaqException;

public interface FaqService {
	public List<FaqDto> getAllFaqs() throws FaqException;
}
