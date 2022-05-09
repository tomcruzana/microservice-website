package dev.company.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "owner_first_name")
	private String ownerFirstName;

	@Column(name = "owner_last_name")
	private String ownerLastName;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "phone_number")
	private String phoneNumber;

	private String slogan;

	@Column(name = "business_hour_start")
	private Date businessHourStart;

	@Column(name = "business_hour_end")
	private Date businessHourEnd;

	@Column(name = "business_days")
	private String businessDays;

	@Embedded
	private Address address;

	public Company() {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
