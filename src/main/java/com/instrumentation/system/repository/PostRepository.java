package com.instrumentation.system.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instrumentation.system.entity.Post;

//Enabling Repository for NON-REPLAY mode 
@Profile("!REPLAY")
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
