package dev.company.coupon.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.company.coupon.entity.Coupon;

public interface CouponRepository extends CrudRepository<Coupon, Integer> {
	public Optional<Coupon> findByCode(String code);
}
