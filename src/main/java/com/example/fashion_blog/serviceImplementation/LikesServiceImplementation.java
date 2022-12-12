package com.example.fashion_blog.serviceImplementation;

import com.example.fashion_blog.exceptions.NotFoundException;
import com.example.fashion_blog.models.Likes;
import com.example.fashion_blog.models.Post;
import com.example.fashion_blog.models.User;
import com.example.fashion_blog.repository.LikesRepository;
import com.example.fashion_blog.repository.PostRepository;
import com.example.fashion_blog.repository.UserRepository;
import com.example.fashion_blog.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikesServiceImplementation implements LikeService {

     private final LikesRepository likesRepository;

     private final PostRepository postRepository;

     private final UserRepository userRepository;


     @Override
     public void likeAPost(Long postId, Long userId) {
          Optional<User> user = userRepository.findById(userId);
          if (user.isEmpty()) {
               throw new NotFoundException("USer Not Found");
          }

          Optional<Post> optionalPost = postRepository.findById(postId);

          if (optionalPost.isEmpty()) {
               throw new NotFoundException("Post Not Found");
          }

          Optional<Likes> optionalLikes = likesRepository.findByUserAndPost(user.get(), optionalPost.get());
          if (optionalLikes.isEmpty()) {
               Likes likes = new Likes();
               likes.setPost(optionalPost.get());
               likes.setUser(user.get());
               likesRepository.save(likes);
          }
          else {
               likesRepository.delete(optionalLikes.get());
          }
     }
}
