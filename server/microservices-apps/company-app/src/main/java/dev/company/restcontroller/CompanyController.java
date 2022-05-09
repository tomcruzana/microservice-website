package dev.company.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.dto.CompanyDto;
import dev.company.service.CompanyService;

@RestController
@RequestMapping("/")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping("/company_info")
	public ResponseEntity<CompanyDto> getCompanyInfo() throws Exception {
		final int companyId = 1;
		CompanyDto companyDto = companyService.getCompany(companyId);
		return new ResponseEntity<>(companyDto, HttpStatus.OK);
	}
}
