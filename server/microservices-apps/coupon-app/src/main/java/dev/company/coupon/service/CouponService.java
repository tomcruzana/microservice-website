package dev.company.coupon.service;

import dev.company.coupon.dto.CouponDto;
import dev.company.coupon.exception.CouponException;

public interface CouponService {
	public CouponDto getCoupon(String code) throws CouponException;
}
