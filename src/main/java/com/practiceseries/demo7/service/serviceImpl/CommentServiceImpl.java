package com.practiceseries.demo7.service.serviceImpl;

import com.practiceseries.demo7.Exception.BlogAPIException;
import com.practiceseries.demo7.Exception.ResourceNotFoundException;
import com.practiceseries.demo7.entity.Comment;
import com.practiceseries.demo7.entity.Post;
import com.practiceseries.demo7.payload.CommentDto;
import com.practiceseries.demo7.repository.CommentRepository;
import com.practiceseries.demo7.repository.PostRepository;
import com.practiceseries.demo7.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private ModelMapper mapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper mapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.mapper = mapper;
    }

    @Override
    public CommentDto savedComment(Long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with this id: " + postId)
        );
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = mapToDto(savedComment);

        return dto;
    }

    @Override
    public List<CommentDto> getPostById(Long postId) {
        List<Comment> getAllList = commentRepository.findByPostId(postId);
        List<CommentDto> dto = getAllList.stream().map(p->mapToDto(p)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post Not Found With this id" +postId )
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new ResourceNotFoundException("Comment Not Found With this id")
        );
        if(comment.getPost() == null ||! comment.getPost().getId().equals(post.getId())){
            new BlogAPIException(HttpStatus.BAD_REQUEST, "comment Not found with this post");
        }
        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post Not Found With this id" +postId )
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new ResourceNotFoundException("Comment Not Found With this id")
        );
        if(comment.getPost() == null ||! comment.getPost().getId().equals(post.getId())){
            new BlogAPIException(HttpStatus.BAD_REQUEST, "comment Not found with this post");
        }
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setName(commentDto.getName());
        Comment savedComment = commentRepository.save(comment);

        return mapToDto(comment);
    }

    @Override
    public CommentDto deleteCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post Not Found With this id" +postId )
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new ResourceNotFoundException("Comment Not Found With this id")
        );
        if(comment.getPost() == null ||! comment.getPost().getId().equals(post.getId())){
            new BlogAPIException(HttpStatus.BAD_REQUEST, "comment Not found with this post");
        }
        commentRepository.deleteById(commentId);
        return mapToDto(comment);
    }


    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = mapper.map(commentDto,Comment.class);
        return comment;
    }

    private CommentDto mapToDto(Comment comment) {
        CommentDto dto = mapper.map(comment,CommentDto.class);
        return dto;
    }

}
