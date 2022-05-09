package dev.company.service;

import dev.company.dto.CompanyDto;
import dev.company.exception.CompanyException;

public interface CompanyService {
	public CompanyDto getCompany(int id) throws CompanyException;
}
