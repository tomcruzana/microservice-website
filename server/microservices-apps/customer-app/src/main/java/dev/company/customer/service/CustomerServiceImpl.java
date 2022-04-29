package dev.company.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import dev.company.customer.dto.CustomerDto;
import dev.company.customer.entity.Customer;
import dev.company.customer.exception.CustomerException;
import dev.company.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService<CustomerDto> {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	private Environment environment;

	@Override
	public CustomerDto findOne(int id) throws CustomerException {
		Optional<Customer> customerOptional = customerRepo.findById(id);
		Customer customerEntity = customerOptional
				.orElseThrow(() -> new CustomerException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));

		// test
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName(customerEntity.getFirstName());
		return customerDto;
	}

	@Override
	public List<CustomerDto> findAll() throws CustomerException {
		List<Customer> allCustomersList = customerRepo.findAll();
		if (allCustomersList.isEmpty()) {
			throw new CustomerException(environment.getProperty("Domain.RESOURCE_NOT_FOUND"));
		}
		// see vivoduck impl
		return null;
	}

	@Override
	public CustomerDto create(CustomerDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto update(CustomerDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int entityId) {
		// TODO Auto-generated method stub
		return false;
	}

}
