package com.instrumentation.system.config;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.instrumentation.system.dto.PostResponse;
import com.instrumentation.system.entity.Post;
import com.instrumentation.system.service.PostService;
import com.instrumentation.system.service.PostServiceImpl;

@Profile("REPLAY")
@Configuration
public class PostServiceMock {

    @Bean
    @Primary
    PostService mockCreateNewPost() {
		PostService postService = Mockito.mock(PostServiceImpl.class);
		when(postService.createNewPost(any())).thenReturn(generateMockPostResponse());
		return postService;
	}

	private PostResponse generateMockPostResponse() {
		return PostResponse.builder().dbRow(generateMockPost()).httpOutbound(generateMockHttpOutbound()).build();
	}

	private Post generateMockPost() {
		return Post.builder().id(24).name("Karan Raina").contents("Hyper Test").build();
	}

	private JsonNode generateMockHttpOutbound() {
		Map<String, Object> httpOutboundMap = new HashMap<>();
		httpOutboundMap.put("abbreviation", "IST");
		httpOutboundMap.put("client_ip", "49.36.99.42");
		httpOutboundMap.put("datetime", "2023-10-20T13:11:32.879911+05:30");
		httpOutboundMap.put("day_of_week", 5);
		httpOutboundMap.put("day_of_year", 293);
		httpOutboundMap.put("dst", false);
		httpOutboundMap.put("dst_from", null);
		httpOutboundMap.put("dst_offset", 0);
		httpOutboundMap.put("dst_until", null);
		httpOutboundMap.put("raw_offset", 19800);
		httpOutboundMap.put("timezone", "Asia/Kolkata");
		httpOutboundMap.put("unixtime", 1697787692);
		httpOutboundMap.put("utc_datetime", "2023-10-20T07:41:32.879911+00:00");
		httpOutboundMap.put("utc_offset", "+05:30");
		httpOutboundMap.put("week_number", 42);

		return new ObjectMapper().convertValue(httpOutboundMap, JsonNode.class);
	}

}
