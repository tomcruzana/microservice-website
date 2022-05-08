package dev.company.guestemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.company.guestemail.repository.GuestEmailRepository;

@Service
public class GuestEmailServiceImpl implements GuestEmailService {

	@Autowired
	private GuestEmailRepository guestEmailRepo;

	@Override
	public String getAllGuestEmails() {
		// cast to string
		String total = String.valueOf(guestEmailRepo.findTotal());
		return total;
	}

}
