package dev.company.privacypolicy.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.privacypolicy.dto.PrivacyPolicyDto;
import dev.company.privacypolicy.service.PrivacyPolicyService;

@RestController
@RequestMapping("/")
public class PrivacyPolicyController {
	@Autowired
	PrivacyPolicyService privacyPolicyService;

	@GetMapping("/privacy_policy")
	public ResponseEntity<PrivacyPolicyDto> getPrivacyPolicy() throws Exception {
		final int privacyPolicyId = 1;
		PrivacyPolicyDto privacyPolicyDto = privacyPolicyService.getPrivacyPolicy(privacyPolicyId);
		return new ResponseEntity<>(privacyPolicyDto, HttpStatus.OK);
	}

}
