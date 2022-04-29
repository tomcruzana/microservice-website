package dev.company.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.company.customer.repository.CustomerEmailRepository;

@Service
public class CustomerEmailServiceImpl implements CustomerEmailService {

	@Autowired
	CustomerEmailRepository customerEmailRepo;

	public int findTotalCustomerEmails() {
		return customerEmailRepo.findTotalCount();
	}

}
