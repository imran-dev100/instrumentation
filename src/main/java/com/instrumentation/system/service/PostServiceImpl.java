package com.instrumentation.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.instrumentation.system.dto.PostResponse;
import com.instrumentation.system.entity.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

	@Value("${external.api}")
	private String externalApi;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private JpaRepository<Post, Long> postRepository;

//	@Transactional
	@Override
	public PostResponse createNewPost(Post post) {
		ResponseEntity<JsonNode> responseEntity = null;
		try {
			// Saving to database
			post = postRepository.save(post);

			// Calling an external HTTP API
			responseEntity = restTemplate.getForEntity(externalApi, JsonNode.class);

			// Checking if status is 200 OK and response has body
			if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.hasBody())
				return PostResponse.builder().dbRow(post).httpOutbound(responseEntity.getBody()).build();
		} catch (DataAccessException de) {
			log.error("Error while saving post: {}", post, de);
		} catch (RestClientException e) {
			log.error("Error occurred during RESTful API call", e);
		}
		throw new HttpClientErrorException(responseEntity.getStatusCode(), "Could not fetch the data from RESTful API");
	}
}
