package dev.company.guestemail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.guestemail.entity.GuestEmail;
import dev.company.guestemail.repository.GuestEmailRepository;
import dev.company.guestemail.service.GuestEmailService;

@SpringBootTest
class GuestEmailAppApplicationTests {

	@Autowired
	private GuestEmailService guestEmailService;

	@Autowired
	private GuestEmailRepository guestEmailRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void getTotalGuestEmailstest() {
		// fail();

		// change this value to the actual count of guest emails
		final int ACTUAL_COUNT = 1;
		Integer count = guestEmailRepo.findTotal();
		assertEquals(count, ACTUAL_COUNT);
	}

	@Test
	public void getResourceServiceLayerTest() throws Exception {
		// fail();
		String allGuestEmails = guestEmailService.getAllGuestEmails();
		assertEquals(Integer.parseInt(allGuestEmails), guestEmailRepo.count());
	}
	
	@Test
	public void createGuestEmail() throws Exception {
		// fail();
		String guestEmailAddress = "fishbold@rmail.com";
		GuestEmail guestEmail = new GuestEmail();
		guestEmail.setEmailAddress(guestEmailAddress);
		guestEmail.setDateCreated(new Date());
		guestEmailRepo.save(guestEmail);
	}

}
