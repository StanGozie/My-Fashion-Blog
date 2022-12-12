package com.example.fashion_blog.controller;

import com.example.fashion_blog.models.Comment;
import com.example.fashion_blog.pojos.CommentDto;
import com.example.fashion_blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/post_a_comment/{email}/{id}")
    public Comment commentOnAPost(@PathVariable("email") String email, @PathVariable("id") Long id, @RequestBody CommentDto commentDto) {
        return commentService.commentOnAPost(email, id, commentDto);
    }


}
