package dev.company.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import dev.company.dto.AddressDto;
import dev.company.dto.CompanyDto;
import dev.company.entity.Company;
import dev.company.exception.CompanyException;
import dev.company.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepo;

	@Autowired
	private Environment environment;

	@Override
	public CompanyDto getCompany(int id) throws CompanyException {
		Optional<Company> companyOptional = companyRepo.findById(id);
		Company company = companyOptional
				.orElseThrow(() -> new CompanyException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));

		CompanyDto companyDto = new CompanyDto();
		AddressDto addressDto = new AddressDto();

		addressDto.setStreet(company.getAddress().getStreet());
		addressDto.setZip(company.getAddress().getZip());
		addressDto.setState(company.getAddress().getState());
		addressDto.setCountry(company.getAddress().getCountry());
		addressDto.setCity(company.getAddress().getCity());

		companyDto.setId(company.getId());
		companyDto.setName(company.getName());
		companyDto.setOwnerFirstName(company.getOwnerFirstName());
		companyDto.setOwnerLastName(company.getOwnerLastName());
		companyDto.setEmailAddress(company.getEmailAddress());
		companyDto.setPhoneNumber(company.getPhoneNumber());
		companyDto.setSlogan(company.getSlogan());
		companyDto.setBusinessHourStart(company.getBusinessHourStart());
		companyDto.setBusinessHourEnd(company.getBusinessHourEnd());
		companyDto.setBusinessDays(company.getBusinessDays());
		companyDto.setAddressDto(addressDto);

		return companyDto;
	}

}
