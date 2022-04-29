package dev.company.customer.dto;

import java.util.Date;

public class CustomerEmailDto {

	private int id;

	private String email;

	private Date dateCreated;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
