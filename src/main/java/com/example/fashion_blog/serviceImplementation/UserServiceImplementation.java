package com.example.fashion_blog.serviceImplementation;

import com.example.fashion_blog.models.User;
import com.example.fashion_blog.pojos.UserRequestDto;
import com.example.fashion_blog.repository.UserRepository;
import com.example.fashion_blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;


    @Override
    public String createUserAccount(UserRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        userRepository.save(user);

        return "Sign-up successful.";
    }

    @Override
    public String userLogin(UserRequestDto requestDto) {
        User user = userRepository.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());
        if (user != null)

        return "Welcome, " + user.getName();
        return "User does not exist";
    }
}
