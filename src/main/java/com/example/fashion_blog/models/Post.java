package com.example.fashion_blog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany (mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "comment", referencedColumnName = "id")
    private List<Comment> commentList;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    //@JoinColumn(name = "likes", referencedColumnName = "id")
    private List<Likes>likesList;

    @ManyToOne(targetEntity = Admin.class)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;

}
