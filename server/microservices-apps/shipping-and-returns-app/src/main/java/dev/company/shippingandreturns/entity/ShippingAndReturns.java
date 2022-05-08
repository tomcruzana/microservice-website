package dev.company.shippingandreturns.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "shipping_and_returns")
public class ShippingAndReturns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "date_created")
	private Date dateCreated;

	private String title;

	@Column(name = "shipping_policy")
	private String shippingPolicy;

	@Column(name = "returns_policy")
	private String returnsPolicy;

	@Lob
	private byte[] photo;

	public ShippingAndReturns() {
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
