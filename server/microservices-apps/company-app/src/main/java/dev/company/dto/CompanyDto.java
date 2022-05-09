package dev.company.dto;

import java.util.Date;

public class CompanyDto {
	private int id;

	private String name;

	private String ownerFirstName;

	private String ownerLastName;

	private String emailAddress;

	private String phoneNumber;

	private String slogan;

	private Date businessHourStart;

	private Date businessHourEnd;

	private String businessDays;

	private AddressDto addressDto;

	public CompanyDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Date getBusinessHourStart() {
		return businessHourStart;
	}

	public void setBusinessHourStart(Date businessHourStart) {
		this.businessHourStart = businessHourStart;
	}

	public Date getBusinessHourEnd() {
		return businessHourEnd;
	}

	public void setBusinessHourEnd(Date businessHourEnd) {
		this.businessHourEnd = businessHourEnd;
	}

	public String getBusinessDays() {
		return businessDays;
	}

	public void setBusinessDays(String businessDays) {
		this.businessDays = businessDays;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

}
