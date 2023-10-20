package com.instrumentation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instrumentation.system.dto.PostResponse;
import com.instrumentation.system.entity.Post;
import com.instrumentation.system.service.PostService;

@RequestMapping("/api")
@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/createNewPost")
	public ResponseEntity<PostResponse> createNewPost(@RequestBody Post post) {
		return new ResponseEntity<>(postService.createNewPost(post), HttpStatus.OK);
	}
}
