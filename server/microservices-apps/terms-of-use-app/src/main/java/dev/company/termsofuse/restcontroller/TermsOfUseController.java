package dev.company.termsofuse.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.termsofuse.dto.TermsOfUseDto;
import dev.company.termsofuse.service.TermsOfUseService;

@RestController
@RequestMapping("/")
public class TermsOfUseController {

	@Autowired
	TermsOfUseService termsOfUseService;

	@GetMapping("/terms_of_use")
	public ResponseEntity<TermsOfUseDto> getTermsOfUse() throws Exception {
		final int termsOfUseId = 1;
		TermsOfUseDto termsOfUseDto = termsOfUseService.getTermsOfUse(termsOfUseId);
		return new ResponseEntity<>(termsOfUseDto, HttpStatus.OK);
	}
}
