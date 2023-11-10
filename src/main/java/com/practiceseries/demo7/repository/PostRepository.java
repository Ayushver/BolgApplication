package com.practiceseries.demo7.repository;

import com.practiceseries.demo7.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
