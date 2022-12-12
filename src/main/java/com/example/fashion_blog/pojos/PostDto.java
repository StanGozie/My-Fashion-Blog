package com.example.fashion_blog.pojos;

import com.example.fashion_blog.models.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String title;
    private String body;
    private Admin admin;
}
