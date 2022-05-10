package dev.company.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	private String id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "registered_customer_id", referencedColumnName = "id")
	RegisteredCustomer registeredCustomer;

	public Cart() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RegisteredCustomer getRegisteredCustomer() {
		return registeredCustomer;
	}

	public void setRegisteredCustomer(RegisteredCustomer registeredCustomer) {
		this.registeredCustomer = registeredCustomer;
	}

}
