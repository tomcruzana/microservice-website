package dev.company.aboutus;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.aboutus.dto.AboutUsDto;
import dev.company.aboutus.entity.AboutUs;
import dev.company.aboutus.exception.AboutUsException;
import dev.company.aboutus.repository.AboutUsRepository;
import dev.company.aboutus.service.AboutUsService;

@SpringBootTest
class AboutUsAppApplicationTests {
	
	@Autowired
	AboutUsService aboutUsService;

	@Autowired
	AboutUsRepository aboutUsRepo;
	
	@Autowired
	Environment environment;

	public AboutUs AboutUsFactory() {
		return new AboutUs();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void getAboutUsByIdTest() {
		// fail();
		int id = 1;
		Optional<AboutUs> aboutUsOptional = aboutUsRepo.findById(id);
		AboutUs aboutUs = aboutUsOptional.get();

		assertNotNull(aboutUs, "About Us loaded!");
	}

	// TODO : test photo upload and download
	@Test
	@Transactional
	@Rollback(value = true)
	public void imageUploadTest() throws IOException {
		// fail();
		AboutUs aboutUs = AboutUsFactory();

		String fileName = "c".toUpperCase();
		String fileType = ".png".toUpperCase();
		File file = new File(environment.getProperty("shipping_and_returns.img.upload.path") + fileName.concat(fileType));
		byte fileContent[] = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		aboutUs.setPhoto(fileContent);
		aboutUs.setOrganizationDescription("Lorem");
		aboutUs.setOrganizationMission("Ipsum");
		aboutUsRepo.save(aboutUs);
		inputStream.close();
	}

	@Test
	public void imageReadTest() throws IOException {
		// fail();
		Optional<AboutUs> aboutUsOptional = aboutUsRepo.findById(1);
		AboutUs aboutUs = aboutUsOptional.get();
		
		// save the read image to this path dir and override if file exists
		String fileName = "aboutUs".toUpperCase();
		String fileType = ".png".toUpperCase();
		File file = new File(environment.getProperty("shipping_and_returns.img.download.path") + fileName.concat(fileType));
		FileOutputStream fos = new FileOutputStream(file);

		// read the image blob from the db
		fos.write(aboutUs.getPhoto());
		fos.close();

	}
	
	@Test
	public void getAboutUsServiceLayerTest() throws AboutUsException {
		// fail();
		int id = 1;
		AboutUsDto aboutUsDto = aboutUsService.getAboutUs(id);
		assertNotNull(aboutUsDto, "About Us is not null!");
	}

}
