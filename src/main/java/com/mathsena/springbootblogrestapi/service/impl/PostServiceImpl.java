package com.mathsena.springbootblogrestapi.service.impl;

import com.mathsena.springbootblogrestapi.entity.Post;
import com.mathsena.springbootblogrestapi.payload.PostDto;
import com.mathsena.springbootblogrestapi.repository.PostRepository;
import com.mathsena.springbootblogrestapi.service.PostService;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // convert DTO to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = new PostDto();
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());
        return postResponse;
    }
}
