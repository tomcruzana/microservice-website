package dev.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CompanyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyAppApplication.class, args);
	}

}
