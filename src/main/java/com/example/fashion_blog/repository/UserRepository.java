package com.example.fashion_blog.repository;

import com.example.fashion_blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User findByEmailAndPassword(String email, String password);
   User findByEmail(String email);
}
