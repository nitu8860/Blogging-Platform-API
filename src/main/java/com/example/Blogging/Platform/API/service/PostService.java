package com.example.Blogging.Platform.API.service;
import com.example.Blogging.Platform.API.dto.PostDTO;
import com.example.Blogging.Platform.API.model.Post;
import com.example.Blogging.Platform.API.repository.IPostRepository;
import com.example.Blogging.Platform.API.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private UserService userService;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IPostRepository postRepository;
    List<Post> allPosts = new ArrayList<>();


    public Post createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setUser(userService.getUserById(postDTO.getUserId()));
        post.setPostBody(postDTO.getPostBody());
        post.setTitle(postDTO.getTitle());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        postRepository.save(post);
        allPosts.add(post);
        return post;
    }


    public List<Post> getPostByUserId(Long userId) {
        List<Post> existingPosts = new ArrayList<>();
        for (Post post : allPosts) {
            if (post.getUser().getUserId() == userId) {
                existingPosts.add(post);
            }
        }
        if (existingPosts.size() == 0) {
            return null;
        }
        return existingPosts.stream().toList();
    }


    public Optional<Post> updatePost(Long userId, Long postId, PostDTO postDTO) {

        Optional<Post> existingPost = postRepository.findById(postId);
        existingPost.get().setPostBody(postDTO.getPostBody());
        existingPost.get().setUpdatedAt(LocalDateTime.now());
        existingPost.get().setTitle(postDTO.getTitle());

        return existingPost;

    }


}