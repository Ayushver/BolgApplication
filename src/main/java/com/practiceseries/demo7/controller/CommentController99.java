package com.practiceseries.demo7.controller;

import com.practiceseries.demo7.payload.CommentDto;
import com.practiceseries.demo7.repository.CommentRepository;
import com.practiceseries.demo7.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController99 {
   private CommentService commentService;

    public CommentController99(CommentService commentService) {
        this.commentService = commentService;
    }
    @PreAuthorize("hasRole('ADMIN)")
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> savedPost(@PathVariable("postId") Long postId,@RequestBody CommentDto commentDto){
        CommentDto dto = commentService.savedComment(postId,commentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getAllComment(@PathVariable Long postId){
       List<CommentDto> dto = commentService.getPostById(postId);
        return dto;
    }

    //get Comment by CommentId
//  @GetMapping("/posts/{postId}/comments/{commentId}")
//  public ResponseEntity<CommentDto> getCommentById(@PathVariable("postId") long postId, @PathVariable("commentId")long commentId){
//      CommentDto dto =   commentService.getCommentById(postId,commentId);
//        return new ResponseEntity<>(dto,HttpStatus.OK);
//  }
    //0123456789
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById (@PathVariable("postId") long postId,@PathVariable("commentId") long commentId ){
        CommentDto dto = commentService.getCommentById(postId,commentId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //update the blog
//    @PutMapping("/posts/{postId}/comment/{commentId}")
//    public  ResponseEntity<CommentDto> updateComment(@PathVariable("postId") Long postId ,@PathVariable("commentId") Long commentId ,@RequestBody CommentDto commentDto ){
//        CommentDto dto = commentService.updateComment(postId,commentId,commentDto);
//        return new ResponseEntity<>(dto,HttpStatus.OK);
//    }
//
//    @DeleteMapping("/posts/{postId}/comment/{commentId}")
//    public ResponseEntity<CommentDto> deleteComment(@PathVariable("postId") Long postId,@PathVariable("commentId") Long commentId){
//        CommentDto dto =  commentService.deleteById(postId,commentId);
//        return new ResponseEntity<>(dto,HttpStatus.OK);
//    }
    //01234
    @PreAuthorize("hasRole('ADMIN)")
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("postId") Long postId,@PathVariable("commentId") Long commentId,@RequestBody CommentDto commentDto){
        CommentDto dto = commentService.updateComment(postId,commentId,commentDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
 }

    @PreAuthorize("hasRole('ADMIN)")
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> deleteCommentById(@PathVariable("postId") Long postId,@PathVariable("commentId") Long commentId){
        CommentDto dto = commentService.deleteCommentById(postId,commentId);
        return new ResponseEntity<>(dto,HttpStatus.OK);

 }


}
