package dev.company.shippingandreturns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShippingAndReturnsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingAndReturnsAppApplication.class, args);
	}

}
