package dev.company.aboutus.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.aboutus.dto.AboutUsDto;
import dev.company.aboutus.service.AboutUsService;

@RestController
@RequestMapping("/aboutusapi")
public class AboutUsController {

	@Autowired
	AboutUsService aboutUsService;

	@GetMapping("/about_us")
	public ResponseEntity<AboutUsDto> getAboutUs() throws Exception {
		final int aboutUsId = 1;
		AboutUsDto aboutUsDto = aboutUsService.getAboutUs(aboutUsId);
		return new ResponseEntity<>(aboutUsDto, HttpStatus.OK);
	}
}
