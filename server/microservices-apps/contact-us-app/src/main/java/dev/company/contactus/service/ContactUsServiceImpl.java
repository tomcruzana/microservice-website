package dev.company.contactus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.company.contactus.dto.ContactUsDto;
import dev.company.contactus.entity.ContactUs;
import dev.company.contactus.exception.ContactUsException;
import dev.company.contactus.repository.ContactUsRepository;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired
	private ContactUsRepository contactUsRepo;

	@Autowired
	private Environment environment;

	@Override
	public void storeContactUsMessage(ContactUsDto contactUsDto) throws ContactUsException {

		if (contactUsDto == null) {
			throw new ContactUsException(environment.getProperty("General.EXCEPTION_MESSAGE"));
		}

		ContactUs contactUs = new ContactUs();
		contactUs.setSenderName(contactUsDto.getSenderName());
		contactUs.setEmailAddress(contactUsDto.getEmailAddress());
		contactUs.setEmailSubject(contactUsDto.getEmailSubject());
		contactUs.setEmailMessage(contactUsDto.getEmailMessage());

		contactUsRepo.save(contactUs);
	}

	@Override
	public ContactUsDto getContactUsMessageById(String id) throws ContactUsException {

		// convert string to integer
		int parsedId;
		try {
			parsedId = Integer.valueOf(id);
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("Order.INPUT_A_NUMBER");
		}

		Optional<ContactUs> contactUsOptional = contactUsRepo.findById(parsedId);
		ContactUs contactUs = contactUsOptional
				.orElseThrow(() -> new ContactUsException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));

		ContactUsDto contactUsDto = new ContactUsDto();
		contactUsDto.setId(contactUs.getId());
		contactUsDto.setDateTimeCreated(contactUs.getDateTimeCreated());
		contactUsDto.setSenderName(contactUs.getSenderName());
		contactUsDto.setEmailAddress(contactUs.getEmailAddress());
		contactUsDto.setEmailSubject(contactUs.getEmailSubject());
		contactUsDto.setEmailMessage(contactUs.getEmailMessage());
		return contactUsDto;
	}

	@Override
	public List<ContactUsDto> getAllContactUsMessages(String page, String size) throws ContactUsException {

		// convert string to integer
		int parsedPage, parsedSize;
		try {
			parsedPage = Integer.valueOf(page);
			parsedSize = Integer.valueOf(size);
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("Order.INPUT_A_NUMBER");
		}

		// sort all result set by date & time created
		Pageable pageConfig = PageRequest.of(parsedPage, parsedSize, Sort.by("dateTimeCreated"));
		Page<ContactUs> contactUsList = contactUsRepo.findAll(pageConfig);

		if (contactUsList.isEmpty()) {
			throw new ContactUsException(environment.getProperty("Domain.RESOURCE_NOT_FOUND"));
		}

		List<ContactUsDto> contactUsDtoList = new ArrayList<>();

		contactUsList.forEach(contactUs -> {
			ContactUsDto contactUsDto = new ContactUsDto();
			contactUsDto.setId(contactUs.getId());
			contactUsDto.setDateTimeCreated(contactUs.getDateTimeCreated());
			contactUsDto.setSenderName(contactUs.getSenderName());
			contactUsDto.setEmailAddress(contactUs.getEmailAddress());
			contactUsDto.setEmailSubject(contactUs.getEmailSubject());
			contactUsDto.setEmailMessage(contactUs.getEmailMessage());

			contactUsDtoList.add(contactUsDto);
		});
		return contactUsDtoList;
	}

}
