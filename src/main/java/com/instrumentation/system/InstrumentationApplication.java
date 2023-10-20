package com.instrumentation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InstrumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstrumentationApplication.class, args);
	}

	@Bean
	RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
}
