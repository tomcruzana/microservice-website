package dev.company.coupon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.company.coupon.dto.CouponDto;
import dev.company.coupon.entity.Coupon;
import dev.company.coupon.exception.CouponException;
import dev.company.coupon.repository.CouponRepository;

@Transactional
@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponRepository couponRepo;

	@Autowired
	private Environment environment;

	@Override
	public CouponDto getCoupon(String code) throws CouponException {
		Optional<Coupon> couponOptional = couponRepo.findByCode(code);
		Coupon coupon = couponOptional
				.orElseThrow(() -> new CouponException(environment.getProperty("Domain.RESOURCE_NOT_FOUND")));

		CouponDto couponDto = new CouponDto();
		couponDto.setId(coupon.getId());
		couponDto.setDateCreated(coupon.getDateCreated());
		couponDto.setDiscount(coupon.getDiscount());
		couponDto.setCode(coupon.getCode().toUpperCase()); // convert the coupon code to upper case
		return couponDto;
	}

}
