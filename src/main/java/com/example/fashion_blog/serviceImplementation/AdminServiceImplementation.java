package com.example.fashion_blog.serviceImplementation;

import com.example.fashion_blog.models.Admin;
import com.example.fashion_blog.pojos.AdminRequestDto;
import com.example.fashion_blog.repository.AdminRepository;
import com.example.fashion_blog.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminService {

    private final AdminRepository adminRepository;

       public AdminServiceImplementation(AdminRepository adminRepository) {
       this.adminRepository = adminRepository;
    }

    @Override
    public String createAdminAccount(AdminRequestDto request) {
         Admin admin = new Admin();
         admin.setName(request.getName());
         admin.setEmail(request.getEmail());
         admin.setPassword(request.getPassword());
         adminRepository.save(admin);
         return "Admin created successfully";
    }

    @Override
    public String adminLogin(AdminRequestDto requestDto) {
        Admin admin = adminRepository.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());
        if(admin != null)

            return "Welcome " + admin.getName();
            return "Admin does not exist";
    }
}
