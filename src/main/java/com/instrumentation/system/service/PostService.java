package com.instrumentation.system.service;

import com.instrumentation.system.dto.PostResponse;
import com.instrumentation.system.entity.Post;

public interface PostService {

	public PostResponse createNewPost(Post post);
}
