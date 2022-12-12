package com.example.fashion_blog.pojos;

import com.example.fashion_blog.models.Post;
import com.example.fashion_blog.models.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    @Column(nullable = false)
    private User user;
    private Post post;
    private String body;

}
