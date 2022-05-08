package dev.company.guestemail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.guestemail.repository.GuestEmailRepository;

@SpringBootTest
class GuestEmailAppApplicationTests {
	
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

}
