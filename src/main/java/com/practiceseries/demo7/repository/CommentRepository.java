package com.practiceseries.demo7.repository;

import com.practiceseries.demo7.entity.Comment;
import com.practiceseries.demo7.payload.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
     public  Comment findByEmail(String email);
     public Comment findByName(String name);
    List<Comment> findByPostId(long postId);



}
