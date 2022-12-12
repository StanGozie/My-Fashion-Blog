package com.example.fashion_blog.repository;

import com.example.fashion_blog.models.Likes;
import com.example.fashion_blog.models.Post;
import com.example.fashion_blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

   Optional<Likes> findByUserAndPost(User user, Post post);

//    Optional<Likes> findByUserAndPost(String email, Long id);
}

    //Optional<Likes> findByUserAndPost(User user, Optional<Post> post)