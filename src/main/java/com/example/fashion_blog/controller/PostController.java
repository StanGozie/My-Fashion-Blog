package com.example.fashion_blog.controller;

import com.example.fashion_blog.models.Post;
import com.example.fashion_blog.pojos.PostDto;
import com.example.fashion_blog.service.PostService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor

public class PostController {

    private final PostService postService;

    @PostMapping("create_post/{id}")
    public String createPost(@PathVariable Long id, @RequestBody PostDto create) {
        return postService.createPost(id, create);
    }

    @PatchMapping("/update_post/{name}/{id}")
    public String updatePost(@PathVariable("name") String name, @PathVariable("id") Long id, @RequestBody PostDto update) {
        return postService.updatePost(name, id, update);
    }

    @DeleteMapping("/delete_post/{name}/{id}")
    public String deletePost(@PathVariable("name") String name, @PathVariable("id") Long id) {
        return postService.deletePost(name, id);
    }

    @GetMapping("/view_one/{email}/{id}")
    public Optional<Post> viewOnePost(@PathVariable("email") String email, @PathVariable("id") Long id) {
        return postService.viewOnePost(email, id);
    }

    @GetMapping("/view_all/{email}")
    public List<Post> viewAllPosts(@PathVariable String email) {
        return postService.viewAllPosts(email);
    }
}

