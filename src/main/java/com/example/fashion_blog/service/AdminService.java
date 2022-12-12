package com.example.fashion_blog.service;

import com.example.fashion_blog.pojos.AdminRequestDto;

public interface AdminService {

    String createAdminAccount (AdminRequestDto request);
    String adminLogin (AdminRequestDto requestDto);
}
