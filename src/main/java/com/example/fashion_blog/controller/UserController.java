package com.example.fashion_blog.controller;

import com.example.fashion_blog.pojos.UserRequestDto;
import com.example.fashion_blog.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    @PostMapping("/user_sing_up")
    public String createUserAccount(@RequestBody UserRequestDto requestDto) {
        return userService.createUserAccount(requestDto);
    }

    @PostMapping("/user_login")
    public String userLogin(@RequestBody UserRequestDto requestDto){
        return userService.userLogin(requestDto);
    }

}
