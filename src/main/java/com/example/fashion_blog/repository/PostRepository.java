package com.example.fashion_blog.repository;

import com.example.fashion_blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository <Post, Long>{

}
