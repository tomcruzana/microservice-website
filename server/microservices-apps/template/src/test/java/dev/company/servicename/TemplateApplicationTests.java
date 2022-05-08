package dev.company.servicename;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplateApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void failingTest() {
		fail();
	}
}
