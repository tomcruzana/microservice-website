package dev.company.guestemail.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.guestemail.service.GuestEmailService;

@RestController
@RequestMapping("/guestemailapi")
public class GuestEmailController {

	@Autowired
	GuestEmailService guestEmailService;

	@Autowired
	Environment environment;

	@GetMapping("/total")
	public ResponseEntity<Map<String, String>> getHome() throws Exception {
		String total = guestEmailService.getAllGuestEmails();
		Map<String, String> guestEmailCount = new HashMap<>();
		guestEmailCount.put("Total", total);
		return new ResponseEntity<>(guestEmailCount, HttpStatus.OK);
	}

	@PostMapping("/subscribe")
	public ResponseEntity<String> addCustomer(@RequestBody String guestEmailAddress) throws Exception {
		guestEmailService.createGuestEmail(guestEmailAddress);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
}
