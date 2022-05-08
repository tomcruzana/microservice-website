package dev.company.termsofuse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import dev.company.termsofuse.dto.TermsOfUseDto;
import dev.company.termsofuse.entity.TermsOfUse;
import dev.company.termsofuse.exception.TermsOfUseException;
import dev.company.termsofuse.repository.TermsOfUseRepository;

@Service
public class TermsOfUseServiceImpl implements TermsOfUseService {

	@Autowired
	TermsOfUseRepository termsOfUseRepo;

	@Autowired
	private Environment environment;

	@Override
	public TermsOfUseDto getTermsOfUse(int id) throws TermsOfUseException {
		Optional<TermsOfUse> termsOfUseOptional = termsOfUseRepo.findById(id);
		TermsOfUse termsOfUse = termsOfUseOptional
				.orElseThrow(() -> new TermsOfUseException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));

		TermsOfUseDto termsOfUseDto = new TermsOfUseDto();
		termsOfUseDto.setId(termsOfUse.getId());
		termsOfUseDto.setDateCreated(termsOfUse.getDateCreated());
		termsOfUseDto.setTitle(termsOfUse.getTitle());
		termsOfUseDto.setDescription(termsOfUse.getDescription());
		return termsOfUseDto;
	}

}
