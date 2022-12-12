package com.example.fashion_blog.controller;

import com.example.fashion_blog.models.Likes;
import com.example.fashion_blog.pojos.LikesDto;
import com.example.fashion_blog.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LikesController {

    private final LikeService likeService;

    @PostMapping ("like-post/{postId}/{userId}")
    public ResponseEntity<String> likeAPost(@PathVariable Long postId, @PathVariable Long userId) {
        likeService.likeAPost(postId, userId);
        return new ResponseEntity<>("liked", HttpStatus.OK);
    }
}
