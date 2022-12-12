package com.example.fashion_blog.service;

import com.example.fashion_blog.models.Likes;
import com.example.fashion_blog.pojos.LikesDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface LikeService {
    void likeAPost(Long postId, Long userId);
}
