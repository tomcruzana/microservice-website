package dev.company.shippingandreturns.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.company.shippingandreturns.dto.ShippingAndReturnsDto;
import dev.company.shippingandreturns.service.ShippingAndReturnsService;

@RestController
@RequestMapping("/")
public class ShippingAndReturnsController {

	@Autowired
	ShippingAndReturnsService shippingAndReturnsService;

	@GetMapping("/shipping_and_returns")
	public ResponseEntity<ShippingAndReturnsDto> getShippingAndReturn() throws Exception {
		final int shippingAndReturnsId = 1;

		ShippingAndReturnsDto shippingAndReturnsDto = shippingAndReturnsService
				.getShippingAndReturns(shippingAndReturnsId);

		return new ResponseEntity<>(shippingAndReturnsDto, HttpStatus.OK);
	}
}
