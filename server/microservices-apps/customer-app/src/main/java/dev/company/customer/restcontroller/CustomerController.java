package dev.company.customer.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.customer.dto.CustomerDto;
import dev.company.customer.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {

	@Autowired
	CustomerService<CustomerDto> customerService;

	/*
	 * TODO: 
	 * 1. refactor dtos
	 * 2. add other http methods
	 * 
	 * */

}
