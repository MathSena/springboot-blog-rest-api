package com.mathsena.springbootblogrestapi.service.impl;

import com.mathsena.springbootblogrestapi.entity.Post;
import com.mathsena.springbootblogrestapi.payload.PostDto;
import com.mathsena.springbootblogrestapi.repository.PostRepository;
import com.mathsena.springbootblogrestapi.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // convert DTO to entity
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = mapToDto(newPost);
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // convert Entity to DTO
    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;

    }

    // convert DTO to entity
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }
}
