package dev.company.productitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductItemAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductItemAppApplication.class, args);
	}

}
