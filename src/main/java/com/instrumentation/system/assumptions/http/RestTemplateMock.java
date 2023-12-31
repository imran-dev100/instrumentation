package com.instrumentation.system.assumptions.http;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.util.LinkedHashMap;
import java.util.Map;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unchecked")
//Enabling for REPLAY mode only
@Profile("REPLAY")
@Configuration
public class RestTemplateMock {

	@Value("${external.api}")
	private String externalApi;
	/**
	 * @return mock of RestTemplate for given externalApi in REPLAY mode only
	 */
	@Bean
	@Profile("REPLAY")
	RestTemplate mockRestTemplate() {
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		// Mocking external API
		when(restTemplate.getForEntity(eq(externalApi), any(Class.class)))
				.thenReturn(new ResponseEntity<>(generateMockHttpOutbound(), HttpStatus.OK));
		return restTemplate;
	}

	private JsonNode generateMockHttpOutbound() {
		// Using LinkedHashMap for maintaining insertion order
		Map<String, Object> httpOutboundMap = new LinkedHashMap<>();
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
