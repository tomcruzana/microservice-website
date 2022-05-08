package dev.company.aboutus;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.aboutus.entity.AboutUs;
import dev.company.aboutus.repository.AboutUsRepository;

@SpringBootTest
class AboutUsAppApplicationTests {

	@Autowired
	AboutUsRepository AboutUsRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAboutUsByIdTest() {
		// fail();
		int id = 1;
		Optional<AboutUs> aboutUsOptional = AboutUsRepo.findById(id);
		AboutUs aboutUs = aboutUsOptional.get();

		assertNotNull(aboutUs, "About Us loaded!");
	}

	// TODO : test photo upload and download

}
