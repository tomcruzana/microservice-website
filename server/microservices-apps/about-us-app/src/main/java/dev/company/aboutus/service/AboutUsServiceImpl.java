package dev.company.aboutus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import dev.company.aboutus.dto.AboutUsDto;
import dev.company.aboutus.entity.AboutUs;
import dev.company.aboutus.exception.AboutUsException;
import dev.company.aboutus.repository.AboutUsRepository;

@Service
public class AboutUsServiceImpl implements AboutUsService {

	@Autowired
	AboutUsRepository AboutUsRepo;

	@Autowired
	private Environment environment;

	@Override
	public AboutUsDto getAboutUs(int id) throws AboutUsException {
		Optional<AboutUs> aboutUsOptional = AboutUsRepo.findById(id);
		AboutUs aboutUs = aboutUsOptional
				.orElseThrow(() -> new AboutUsException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));

		AboutUsDto aboutUsDto = new AboutUsDto();
		aboutUsDto.setId(aboutUs.getId());
		aboutUsDto.setDateCreated(aboutUs.getDateCreated());
		aboutUsDto.setPhoto(aboutUs.getPhoto());
		aboutUsDto.setOrganizationDescription(aboutUs.getOrganizationDescription());
		aboutUsDto.setOrganizationMission(aboutUs.getOrganizationMission());
		aboutUsDto.setOrganizationTitle(aboutUs.getOrganizationTitle());
		aboutUsDto.setOrganizationValues(aboutUs.getOrganizationValues());
		aboutUsDto.setOrganizationVision(aboutUs.getOrganizationVision());

		return aboutUsDto;
	}

}
