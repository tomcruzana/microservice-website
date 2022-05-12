package dev.company.faq.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.company.faq.dto.FaqDto;
import dev.company.faq.service.FaqService;

@RestController
@RequestMapping("/")
public class FaqController {

	@Autowired
	FaqService faqService;

	@GetMapping("/faqs")
	public ResponseEntity<List<FaqDto>> getFaqs() throws Exception {
		List<FaqDto> faqDtoList = faqService.getAllFaqs();
		return new ResponseEntity<>(faqDtoList, HttpStatus.OK);
	}

	@GetMapping("/faqs/q")
	public ResponseEntity<FaqDto> getFaqById(@RequestParam int id) throws Exception {
		FaqDto faqDto = faqService.getFaqById(id);
		return new ResponseEntity<>(faqDto, HttpStatus.OK);
	}

}
