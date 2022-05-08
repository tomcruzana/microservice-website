package dev.company.termsofuse.service;

import dev.company.termsofuse.dto.TermsOfUseDto;
import dev.company.termsofuse.exception.TermsOfUseException;

public interface TermsOfUseService {
	public TermsOfUseDto getTermsOfUseById(int id) throws TermsOfUseException;
}
