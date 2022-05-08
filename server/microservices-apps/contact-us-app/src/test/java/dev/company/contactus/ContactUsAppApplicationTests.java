package dev.company.contactus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.contactus.entity.ContactUs;
import dev.company.contactus.repository.ContactUsRepository;

@SpringBootTest
class ContactUsAppApplicationTests {

	@Autowired
	private ContactUsRepository contactUsRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllContactUsMessagesTest() {
		// fail();

		// get all result set
		Pageable pageConfig = Pageable.unpaged();

		Page<ContactUs> contactUsList = contactUsRepo.findAll(pageConfig);

		assertEquals(contactUsList.getSize(), contactUsRepo.count());
	}

	@Test
	public void getContactUsMessageByIdTest() {
		// fail();
		int id = 1;
		Optional<ContactUs> contactUsOptional = contactUsRepo.findById(id);

		ContactUs contactUs = new ContactUs();
		contactUs = contactUsOptional.get();

		assertTrue(contactUs.getId() == 1);

	}

	@Test
	@Transactional
	@Rollback(true)
	public void createContactUsMessageTest() {
		// fail();
		ContactUs contactUs = new ContactUs();
		contactUs.setSenderName("Depth Smith");
		contactUs.setEmailAddress("johny.depth77@email.com");

		// email subject left with white space by design
		contactUs.setEmailSubject(" ");
		contactUs.setEmailMessage("lorem ipsum dolor amet.");

		contactUsRepo.save(contactUs);
	}

	@Test
	public void defaultEmailSubjectTest() {
		// fail();
		int id = 1;
		Optional<ContactUs> contactUsOptional = contactUsRepo.findById(id);
		ContactUs contactUs = new ContactUs();
		contactUs = contactUsOptional.get();

		assertEquals("EMAIL SUBJECT", contactUs.getEmailSubject());
	}
}
