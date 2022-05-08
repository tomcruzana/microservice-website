package dev.company.contactus.service;

import java.util.List;

import dev.company.contactus.dto.ContactUsDto;
import dev.company.contactus.exception.ContactUsException;

public interface ContactUsService {
	public void storeContactUsMessage(ContactUsDto contactUsDto) throws ContactUsException;

	public ContactUsDto getContactUsMessageById(String id) throws ContactUsException;

	public List<ContactUsDto> getAllContactUsMessages(String page, String size) throws ContactUsException;
}
