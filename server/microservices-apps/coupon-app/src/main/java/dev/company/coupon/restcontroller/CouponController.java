package dev.company.coupon.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.company.coupon.dto.CouponDto;
import dev.company.coupon.service.CouponService;

@RestController
@RequestMapping("/")
public class CouponController implements ErrorController {

	@Autowired
	CouponService couponService;

	// TODO: make all rest resource
	@GetMapping("/validate")
	public ResponseEntity<CouponDto> validateCouponCode(@RequestParam String code) throws Exception {
		CouponDto couponDto = couponService.getCoupon(code);
		return new ResponseEntity<>(couponDto, HttpStatus.OK);
	}

	// TODO: refactor error and return json
	// https://www.toptal.com/java/spring-boot-rest-api-error-handling
	@RequestMapping("/error")
	@ResponseBody
	public ResponseEntity<Map<String, String>> getErrorPath() {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", "not a valid coupon");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
