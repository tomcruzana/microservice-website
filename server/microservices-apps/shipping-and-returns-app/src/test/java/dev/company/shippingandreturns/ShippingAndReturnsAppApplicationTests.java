package dev.company.shippingandreturns;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import dev.company.shippingandreturns.entity.ShippingAndReturns;
import dev.company.shippingandreturns.repository.ShippingAndReturnsRepository;

@SpringBootTest
class ShippingAndReturnsAppApplicationTests {

	@Autowired
	ShippingAndReturnsRepository shippingAndReturnsRepo;

	@Autowired
	Environment environment;

	public ShippingAndReturns ShippingAndReturnsFactory() {
		return new ShippingAndReturns();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllTermsOfUseTest() {
		// fail();
		Iterable<ShippingAndReturns> all = shippingAndReturnsRepo.findAll();

		// get total of TermsOfUse instances
		long size = all.spliterator().getExactSizeIfKnown();

		// perform SQL aggregate count query
		assertEquals(size, shippingAndReturnsRepo.count());
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void imageUploadTest() throws IOException {
		// fail();
		ShippingAndReturns shippingAndReturns = ShippingAndReturnsFactory();

		String fileName = "c".toUpperCase();
		String fileType = ".png".toUpperCase();
		File file = new File(environment.getProperty("shipping_and_returns.img.upload.path") + fileName.concat(fileType));
		byte fileContent[] = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		shippingAndReturns.setTitle("shipping & returns");
		shippingAndReturns.setShippingPolicy("Lorem ipsum dolor amet");
		shippingAndReturns.setReturnsPolicy("Lorem ipsum dolor amet");
		shippingAndReturns.setPhoto(fileContent);

		shippingAndReturnsRepo.save(shippingAndReturns);
		inputStream.close();
	}

	@Test
	public void imageReadTest() throws IOException {
		// fail();
		Optional<ShippingAndReturns> shippingAndReturnsOptional = shippingAndReturnsRepo.findById(2);
		ShippingAndReturns shippingAndReturns = shippingAndReturnsOptional.get();
		System.out.println(shippingAndReturns.getTitle());
		
		// save the read image to this path dir and override if file exists
		String fileName = "shippingAndReturns".toUpperCase();
		String fileType = ".png".toUpperCase();
		File file = new File(environment.getProperty("shipping_and_returns.img.download.path") + fileName.concat(fileType));
		FileOutputStream fos = new FileOutputStream(file);

		// read the image blob from the db
		fos.write(shippingAndReturns.getPhoto());
		fos.close();

	}
}
