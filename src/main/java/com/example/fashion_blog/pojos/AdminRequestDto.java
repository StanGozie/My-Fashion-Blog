package com.example.fashion_blog.pojos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminRequestDto {
    private String name;
    private String email;
    private String password;
}
