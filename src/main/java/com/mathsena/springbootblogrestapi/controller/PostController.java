package com.mathsena.springbootblogrestapi.controller;

import com.mathsena.springbootblogrestapi.payload.PostDto;
import com.mathsena.springbootblogrestapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    // Create blog post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // Getting all posts
    @GetMapping()
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // Getting Post By Id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));

    }

}
