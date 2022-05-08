package dev.company.guestemail.service;

import dev.company.guestemail.exception.GuestEmailException;

public interface GuestEmailService {
	public String getAllGuestEmails() throws GuestEmailException;
}
