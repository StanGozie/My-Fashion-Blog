package com.example.fashion_blog.controller;

import com.example.fashion_blog.pojos.AdminRequestDto;
import com.example.fashion_blog.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {


    private final AdminService adminService;

    @PostMapping("/create_admin")
    public String createAdminAccount(@RequestBody AdminRequestDto request) {
         return adminService.createAdminAccount(request);
    }

    @PostMapping("/admin_login")
    String adminLogin(@RequestBody AdminRequestDto requestDto) {
        return adminService.adminLogin(requestDto);
    }
}
