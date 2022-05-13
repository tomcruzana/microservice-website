package dev.company.aboutus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AboutUsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboutUsAppApplication.class, args);
	}

}
