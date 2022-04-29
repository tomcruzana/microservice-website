package dev.company.customer.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.customer.service.CustomerEmailService;

@RestController
public class CustomerEmailController {

	@Autowired
	CustomerEmailService customerEmailService;

	@GetMapping("/email/total")
	public ResponseEntity<PersistentEntityResource> getTotalCustomerEmails(
			PersistentEntityResourceAssembler assembler) {
		String totalEmails = String.valueOf(customerEmailService.findTotalCustomerEmails());
		return ResponseEntity.ok(assembler.toFullResource(totalEmails));
	}
}
