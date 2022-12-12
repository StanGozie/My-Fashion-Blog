package com.example.fashion_blog.service;

import com.example.fashion_blog.pojos.UserRequestDto;

public interface UserService {

    String createUserAccount (UserRequestDto requestDto);

    String userLogin(UserRequestDto requestDto);
}
