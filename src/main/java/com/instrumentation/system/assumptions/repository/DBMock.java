package com.instrumentation.system.assumptions.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.instrumentation.system.entity.Post;

//Enabling for REPLAY mode only
@Profile("REPLAY")
@Configuration
public class DBMock {
	
//	@Profile("REPLAY")
//	@Bean
//	@Primary
//	SimpleJpaRepository<?, ?> mockJpa() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//		Class<? extends SimpleJpaRepository> dynamicType = new ByteBuddy().subclass(SimpleJpaRepository.class)
//				.method(ElementMatchers.named("save"))
//				.intercept(FixedValue.value(Post.builder().id(24).name("Karan Raina").contents("HyperTest").build()))
//				.make()
//				.load(ByteBuddyInterceptor.class.getClassLoader()).getLoaded();
//
//		SimpleJpaRepository mockedRepo = dynamicType.getDeclaredConstructor().newInstance();
//		Object result = mockedRepo.save(new Object()); // This should return null due to our mock
//		System.out.println(result); // Should print null
//
//		return dynamicType.getDeclaredConstructor().newInstance();
//	}

	@Bean
	@Primary
	@Profile("REPLAY")
	SimpleJpaRepository<?, ?> mock(){
		SimpleJpaRepository<?, ?> simpleJpaRepository = Mockito.mock(SimpleJpaRepository.class);
		when(simpleJpaRepository.save(any())).thenReturn(Post.builder().id(24).name("Karan Raina").contents("HyperTest").build());		
		return simpleJpaRepository;
	} 
	


}
