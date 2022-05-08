package dev.company.shippingandreturns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import dev.company.shippingandreturns.dto.ShippingAndReturnsDto;
import dev.company.shippingandreturns.entity.ShippingAndReturns;
import dev.company.shippingandreturns.exception.ShippingAndReturnsException;
import dev.company.shippingandreturns.repository.ShippingAndReturnsRepository;

@Service
public class ShippingAndReturnsServiceImpl implements ShippingAndReturnsService {

	@Autowired
	ShippingAndReturnsRepository shippingAndReturnsRepo;

	@Autowired
	private Environment environment;

	@Override
	public ShippingAndReturnsDto getShippingAndReturns(int id) throws ShippingAndReturnsException {
		Optional<ShippingAndReturns> shippingAndReturnsOptional = shippingAndReturnsRepo.findById(id);
		ShippingAndReturns shippingAndReturns = shippingAndReturnsOptional.orElseThrow(
				() -> new ShippingAndReturnsException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));

		ShippingAndReturnsDto shippingAndReturnsDto = new ShippingAndReturnsDto();
		shippingAndReturnsDto.setId(shippingAndReturns.getId());
		shippingAndReturnsDto.setPhoto(shippingAndReturns.getPhoto());
		shippingAndReturnsDto.setDateCreated(shippingAndReturns.getDateCreated());
		shippingAndReturnsDto.setTitle(shippingAndReturns.getTitle());
		shippingAndReturnsDto.setShippingPolicy(shippingAndReturns.getShippingPolicy());
		shippingAndReturnsDto.setReturnsPolicy(shippingAndReturns.getReturnsPolicy());
		return shippingAndReturnsDto;
	}

}
