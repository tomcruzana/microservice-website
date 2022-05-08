package dev.company.contactus.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.company.contactus.dto.ContactUsDto;
import dev.company.contactus.service.ContactUsService;

@RestController
@RequestMapping("/")
public class ContactUsController {

	@Autowired
	private Environment environment;

	@Autowired
	private ContactUsService contactUsService;

	@GetMapping("/contact_us/q")
	public ResponseEntity<ContactUsDto> getTermsOfUse(@RequestParam String id) throws Exception {
		ContactUsDto contactUsDto = contactUsService.getContactUsMessageById(id);
		return new ResponseEntity<>(contactUsDto, HttpStatus.OK);
	}

	@GetMapping("/contact_us/all")
	public ResponseEntity<List<ContactUsDto>> getAllContactUsMessages(@RequestParam String page,
			@RequestParam String size) throws Exception {
		List<ContactUsDto> contactUsListDto = contactUsService.getAllContactUsMessages(page, size);
		return new ResponseEntity<>(contactUsListDto, HttpStatus.OK);
	}

	@PostMapping("/contact_us")
	public ResponseEntity<String> ContactUsMessage(ContactUsDto contactUsDto) throws Exception {
		contactUsService.storeContactUsMessage(contactUsDto);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
}
