package dev.company;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

	@Test
	public void getCompanyAddressInfoTest() {
		// fail();
		int id = 1;
		Optional<Company> companyOptional = companyRepository.findById(id);
		Company company = companyOptional.get();

		System.out.printf("\n" + "Street: %s \n" + "City: %s \n" + "Country: %s \n" + "State: %s \n" + "Zip: %s" + "\n",
				company.getAddress().getStreet(), company.getAddress().getCity(), company.getAddress().getCountry(),
				company.getAddress().getState(), company.getAddress().getZip());
		assertNotNull(company, "Company address details found!");
	}

}
