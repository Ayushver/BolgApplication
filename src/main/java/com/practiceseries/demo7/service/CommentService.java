package com.practiceseries.demo7.service;

import com.practiceseries.demo7.payload.CommentDto;

import java.util.List;

public interface CommentService {
    public CommentDto savedComment(Long postId, CommentDto commentDto);
    public  List<CommentDto> getPostById(Long postId);
    public  CommentDto getCommentById(long postId, long commentId);
  public  CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto);
  public  CommentDto deleteCommentById(Long postId, Long commentId);
}
