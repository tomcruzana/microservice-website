package dev.company.coupon;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.coupon.dto.CouponDto;
import dev.company.coupon.entity.Coupon;
import dev.company.coupon.repository.CouponRepository;
import dev.company.coupon.service.CouponService;

@SpringBootTest
class CouponAppApplicationTests {

	@Autowired
	private CouponService couponService;

	@Autowired
	CouponRepository couponRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void getCouponByCodeTest() {
		// fail();
		String code = "zxvlabs".toUpperCase();
		Optional<Coupon> coupon = couponRepo.findByCode(code);
		assertTrue(!coupon.isEmpty(), "Coupon exists!");
	}

	@Test
	public void checkCouponIfActiveTest() {
		// fail();
		String code = "chicky90".toUpperCase();
		Optional<Coupon> coupon = couponRepo.findByCode(code);
		assertFalse(coupon.get().isActive(), "Coupon is inactive!");
	}

	@Test
	public void getResourceServiceLayerTest() throws Exception {
		// fail();
		String code = "chicky90".toUpperCase();
		CouponDto couponDto = couponService.getCoupon(code);
		assertNotNull(couponDto, "Resource is not null!");
	}

}
