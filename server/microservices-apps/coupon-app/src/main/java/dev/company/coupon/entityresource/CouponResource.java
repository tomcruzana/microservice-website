package dev.company.coupon.entityresource;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

public class CouponResource extends RepresentationModel<CouponResource> {

	private Date dateCreated;

	private String code;

	private BigDecimal discount;

	
	public CouponResource(Date dateCreated, String code, BigDecimal discount) {
		this.dateCreated = dateCreated;
		this.code = code;
		this.discount = discount;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getCode() {
		return code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

}
