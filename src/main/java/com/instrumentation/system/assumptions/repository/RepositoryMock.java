package com.instrumentation.system.assumptions.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.instrumentation.system.assumptions.config.CustomEntityManager;
import com.instrumentation.system.assumptions.config.CustomJpaEntityInformation;
import com.instrumentation.system.assumptions.config.CustomSimpleJpaRepository;

//Enabling for REPLAY mode only
@Profile("REPLAY")
@Configuration
@EnableJpaAuditing
public class RepositoryMock {
	/**
	 * @return mock of SimpleJpaRepository of all entities in REPLAY mode only
	 */
	@Bean
	@Primary
	@Profile("REPLAY")
	SimpleJpaRepository<?, ?> mockJpaRepository() {
		return new CustomSimpleJpaRepository<>(new CustomJpaEntityInformation<>(), new CustomEntityManager());
	}
}
