package dev.company.termsofuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TermsOfUseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TermsOfUseAppApplication.class, args);
	}

}
