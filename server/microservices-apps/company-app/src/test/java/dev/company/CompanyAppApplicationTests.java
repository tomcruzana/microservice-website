package dev.company;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.entity.Company;
import dev.company.repository.CompanyRepository;

@SpringBootTest
class CompanyAppApplicationTests {
	
	@Autowired
	CompanyRepository companyRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getCompanyInfoTest() {
		// fail();
		int id = 1;
		Optional<Company> companyOptional = companyRepository.findById(id);
		Company company = companyOptional.get();
		assertNotNull(company, "Company details found!");
	}

}
