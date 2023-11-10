package com.practiceseries.demo7.service.serviceImpl;

import com.practiceseries.demo7.entity.Post;
import com.practiceseries.demo7.payload.PostDto;
import com.practiceseries.demo7.repository.PostRepository;
import com.practiceseries.demo7.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostSeviceImpl implements PostService{
   private PostRepository postRepository;
   private ModelMapper mapper;

    public PostSeviceImpl(PostRepository postRepository, ModelMapper mapper) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost =postRepository.save(post);
        PostDto dto = mapToDto(post);

        return dto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> listAllPost = postRepository.findAll();
        List<PostDto> listAllPostDto = listAllPost.stream().map(p->mapToDto(p)).collect(Collectors.toList());
        return listAllPostDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        return null;
    }

    @Override
    public void deletePostById(long id) {

    }

    @Override
    public Object getPostById(long id) {
        return null;
    }

    public Post mapToEntity(PostDto postDto){
       Post post =  mapper.map(postDto,Post.class);
//        Post post = new Post();
//        post.setId(postDto.getId());
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getDescription());
//        post.setDescription(postDto.getDescription());
        return post;
    }

    public PostDto mapToDto(Post post){
        PostDto dto = mapper.map(post,PostDto.class);
//        PostDto dto = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setContent(post.getContent());
//        dto.setDescription(post.getDescription());
        return dto;
    }
}
