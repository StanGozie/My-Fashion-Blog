package com.example.fashion_blog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (targetEntity = Post.class)
    @JoinColumn(name = "post_Id", referencedColumnName = "id")
    private Post post;

    @ManyToOne (targetEntity = User.class)
    @JoinColumn(name = "user_Id", referencedColumnName = "id")
    private User user;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
