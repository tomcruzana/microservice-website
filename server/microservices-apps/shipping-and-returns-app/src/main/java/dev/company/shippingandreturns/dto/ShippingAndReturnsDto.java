package dev.company.shippingandreturns.dto;

import java.util.Date;

public class ShippingAndReturnsDto {
	private int id;

	private Date dateCreated;

	private String title;

	private String shippingPolicy;


	private String returnsPolicy;

	private byte[] photo;

	public ShippingAndReturnsDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShippingPolicy() {
		return shippingPolicy;
	}

	public void setShippingPolicy(String shippingPolicy) {
		this.shippingPolicy = shippingPolicy;
	}

	public String getReturnsPolicy() {
		return returnsPolicy;
	}

	public void setReturnsPolicy(String returnsPolicy) {
		this.returnsPolicy = returnsPolicy;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
