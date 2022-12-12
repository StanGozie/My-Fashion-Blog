package com.example.fashion_blog.service;

import com.example.fashion_blog.models.Comment;
import com.example.fashion_blog.pojos.CommentDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface CommentService {

    Comment commentOnAPost (@PathVariable String email, @PathVariable Long Id, CommentDto comment);


}
