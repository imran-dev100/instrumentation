package com.instrumentation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InstrumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstrumentationApplication.class, args);
	}
	/**
	 * @return RestTemplate for NON-REPLAY profiles only
	 */
	@Bean
	@Profile("!REPLAY")
	RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
}
