package com.example.fashion_blog.pojos;

import com.example.fashion_blog.models.Post;
import com.example.fashion_blog.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikesDto {
    private Post post;
    private User user;
}
