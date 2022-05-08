package dev.company.aboutus.service;

import dev.company.aboutus.dto.AboutUsDto;
import dev.company.aboutus.exception.AboutUsException;

public interface AboutUsService {
	public AboutUsDto getAboutUs(int id) throws AboutUsException;
}
