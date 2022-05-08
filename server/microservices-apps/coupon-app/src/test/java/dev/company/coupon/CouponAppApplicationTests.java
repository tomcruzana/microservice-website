package dev.company.coupon;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.company.coupon.entity.Coupon;
import dev.company.coupon.repository.CouponRepository;

@SpringBootTest
class CouponAppApplicationTests {

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

}
