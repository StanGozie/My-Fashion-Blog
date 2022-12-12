package com.example.fashion_blog.serviceImplementation;

import com.example.fashion_blog.exceptions.NotFoundException;
import com.example.fashion_blog.models.Admin;
import com.example.fashion_blog.models.Post;
import com.example.fashion_blog.models.User;
import com.example.fashion_blog.pojos.PostDto;
import com.example.fashion_blog.repository.AdminRepository;
import com.example.fashion_blog.repository.PostRepository;
import com.example.fashion_blog.repository.UserRepository;
import com.example.fashion_blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    //private final CommentRepository commentRepository;

    @Override
    public String createPost(@PathVariable("id") Long id, @RequestBody PostDto create) {
        Optional<Admin> admin = Optional.ofNullable(adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Admin Not Found")));

        Post post = new Post();
        post.setTitle(create.getTitle());
        post.setBody(create.getBody());
        postRepository.save(post);

        return "Post created";
    }

    @Override
    public String updatePost(@PathVariable("name") String name, @PathVariable("id") Long id, @RequestBody PostDto postDto) {
        Optional<Admin> admin = Optional.of(adminRepository.findByName(name));

        if (name != null) {
            return postRepository.findById(id).map(record -> {
                record.setTitle(postDto.getTitle());
                record.setBody(postDto.getBody());
                postRepository.save(record);
                return "Post has been updated";
            }).orElse("Post does not exist");

        }
        return "update successful";
    }

    @Override
    public String deletePost (@PathVariable("name") String name, @PathVariable("id") Long id) {
        Optional<Admin> admin = Optional.of(adminRepository.findByName(name));
        if (name != null) {
            Optional<Post> myPost = postRepository.findById(id);
            if (myPost.isPresent())
            postRepository.deleteById(id);
         }
        return "Post has been deleted";
    }

    @Override
    public Optional<Post> viewOnePost(@PathVariable("email") String email, @PathVariable("id") Long id) {
        Optional<User> optionalUser = Optional.of(userRepository.findByEmail(email));
        if (email != null) {
            Optional<Post> blogPost = postRepository.findById(id);
            if (blogPost.isPresent())
            return postRepository.findById(id);
        }

        return Optional.empty();
    }

    @Override
    public List<Post> viewAllPosts(String email) {
        Optional<User> optionalUser = Optional.of(userRepository.findByEmail(email));
        if (email != null) {
            List<Post> blogPosts;
            return postRepository.findAll();
                //return postRepository.findAll();
        }
        return null;
    }

//    @Override
//    public List<Post> viewAllCommentsOnAPost(Long id, UserRequestDto requestDto) {
//        return null;
//    }

//    @Override
//    public List<Post> likePost(Long id, UserRequestDto requestDto) {
//        return null;
//    }

}


