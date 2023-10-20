package com.instrumentation.system.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.instrumentation.system.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PostResponse {

	@JsonProperty("db_row")
	private Post dbRow;
	
	@JsonProperty("http_outbound")
	private JsonNode httpOutbound;
}
