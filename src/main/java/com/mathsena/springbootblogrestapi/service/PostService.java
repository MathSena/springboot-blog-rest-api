package com.mathsena.springbootblogrestapi.service;

import com.mathsena.springbootblogrestapi.payload.PostDto;
import com.mathsena.springbootblogrestapi.payload.PostResponse;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);


}
