package com.practiceseries.demo7.service;

import com.practiceseries.demo7.payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createPost(PostDto postDto);

     public  List<PostDto> getAllPosts();

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    Object getPostById(long id);
}
