package com.example.fashion_blog.serviceImplementation;

import com.example.fashion_blog.models.Comment;
import com.example.fashion_blog.models.Post;
import com.example.fashion_blog.models.User;
import com.example.fashion_blog.pojos.*;
import com.example.fashion_blog.repository.CommentRepository;
import com.example.fashion_blog.repository.PostRepository;
import com.example.fashion_blog.repository.UserRepository;
import com.example.fashion_blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImplementation implements CommentService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    @Override
    public Comment commentOnAPost(String email, Long id, CommentDto commentDto) {
        Optional<User> optionalUser = Optional.of(userRepository.findByEmail(email));
        if (optionalUser.isPresent()) {
            Optional<Post> optionalPost = postRepository.findById(id);
            Comment comment = new Comment();
            comment.setBody(commentDto.getBody());
            return commentRepository.save(comment);
        }
        return null;
    }



}



