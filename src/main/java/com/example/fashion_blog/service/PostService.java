package com.example.fashion_blog.service;

import com.example.fashion_blog.models.Post;
import com.example.fashion_blog.pojos.PostDto;
import com.example.fashion_blog.pojos.UserRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    String createPost (Long adminId, PostDto create);

    String  updatePost(@PathVariable("name") String name, @PathVariable("id") Long id, @RequestBody PostDto update);

    String deletePost(@PathVariable("name") String name, @PathVariable("id") Long id);

    Optional<Post> viewOnePost(@PathVariable("email") String email, @PathVariable Long id);

    List<Post> viewAllPosts (@PathVariable("email") String email);

    //List<Post> commentOnPost (@PathVariable Long id, @RequestBody UserRequestDto requestDto);

    //List<Post> likePost (@PathVariable Long id, @RequestBody UserRequestDto requestDto);
}
