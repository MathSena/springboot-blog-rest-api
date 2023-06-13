package com.mathsena.springbootblogrestapi.service;

import com.mathsena.springbootblogrestapi.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);


}
