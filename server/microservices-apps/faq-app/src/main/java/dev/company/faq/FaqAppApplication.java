package dev.company.faq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FaqAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaqAppApplication.class, args);
	}

}
