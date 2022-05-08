package dev.company.shippingandreturns.service;

import dev.company.shippingandreturns.dto.ShippingAndReturnsDto;
import dev.company.shippingandreturns.exception.ShippingAndReturnsException;

public interface ShippingAndReturnsService {
	public ShippingAndReturnsDto getShippingAndReturns(int id) throws ShippingAndReturnsException;
}
