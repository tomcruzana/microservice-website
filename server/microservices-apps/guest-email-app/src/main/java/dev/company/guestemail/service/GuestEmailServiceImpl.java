package dev.company.guestemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import dev.company.guestemail.dto.GuestEmailDto;
import dev.company.guestemail.entity.GuestEmail;
import dev.company.guestemail.exception.GuestEmailException;
import dev.company.guestemail.repository.GuestEmailRepository;

@Service
public class GuestEmailServiceImpl implements GuestEmailService {

	@Autowired
	private Environment environment;

	@Autowired
	private GuestEmailRepository guestEmailRepo;

	@Override
	public String getAllGuestEmails() throws GuestEmailException {

		// cast to string
		String total = String.valueOf(guestEmailRepo.findTotal());

		if (total.isEmpty()) {
			throw new GuestEmailException(environment.getProperty("General.EXCEPTION_MESSAGE"));
		}
		return total;
	}

	@Override
	public void createGuestEmail(String guestEmailAddress) throws GuestEmailException {
		GuestEmail guestEmail = new GuestEmail();
		guestEmail.setEmailAddress(guestEmailAddress);
		guestEmailRepo.save(guestEmail);

	}

}
