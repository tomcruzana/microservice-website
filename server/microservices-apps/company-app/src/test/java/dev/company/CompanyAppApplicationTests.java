package dev.company;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.entity.Address;
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
	@Transactional
	@Rollback(true)
	public void createCompanyInfoTest() {
		// fail();
		Company company = new Company();
		company.setName("hedwig, inc");
		company.setOwnerFirstName("hedwig");
		company.setOwnerLastName("schnorky");
		company.setEmailAddress("none@rmail.com");
		company.setPhoneNumber("3789201234");
		company.setSlogan("in god we trust");
		
		Address address = new Address();
		address.setCity("burp");
		address.setCountry("USB");
		address.setState("ZX");
		address.setStreet("1000 alfred s");
		address.setZip("12345");
		
		company.setAddress(address);

		companyRepository.save(company);
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
