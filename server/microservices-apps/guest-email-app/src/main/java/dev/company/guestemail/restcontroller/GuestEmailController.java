package dev.company.guestemail.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.guestemail.service.GuestEmailService;

@RestController
@RequestMapping("/")
public class GuestEmailController {

	@Autowired
	GuestEmailService guestEmailService;

	@GetMapping("/total")
	public ResponseEntity<Map<String, String>> getHome() throws Exception {
		String total = guestEmailService.getAllGuestEmails();
		Map<String, String> guestEmailCount = new HashMap<>();
		guestEmailCount.put("Total", total);
		return new ResponseEntity<>(guestEmailCount, HttpStatus.OK);
	}
}
