package com.mathsena.springbootblogrestapi.service;

import com.mathsena.springbootblogrestapi.payload.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto);
}
