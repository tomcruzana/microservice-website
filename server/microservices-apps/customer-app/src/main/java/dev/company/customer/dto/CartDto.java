package dev.company.customer.dto;

import java.util.List;

public class CartDto {

	private String id;

	RegisteredCustomerDto registeredCustomerDto;

	List<CartItemDto> cartItemsDto;

	public CartDto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RegisteredCustomerDto getRegisteredCustomerDto() {
		return registeredCustomerDto;
	}

	public void setRegisteredCustomerDto(RegisteredCustomerDto registeredCustomerDto) {
		this.registeredCustomerDto = registeredCustomerDto;
	}

	public List<CartItemDto> getCartItemsDto() {
		return cartItemsDto;
	}

	public void setCartItemsDto(List<CartItemDto> cartItemsDto) {
		this.cartItemsDto = cartItemsDto;
	}

}
