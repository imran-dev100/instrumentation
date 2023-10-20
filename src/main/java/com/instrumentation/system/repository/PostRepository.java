package com.instrumentation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instrumentation.system.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
