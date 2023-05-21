package com.example.Blogging.Platform.API.service;
import com.example.Blogging.Platform.API.model.Comment;
import com.example.Blogging.Platform.API.repository.ICommentRepository;
import com.example.Blogging.Platform.API.repository.IPostRepository;
import com.example.Blogging.Platform.API.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private ICommentRepository commentRepository;
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPostRepository postRepository;

    public Comment add(Long userId, Long postId, String reqCom) {
        Comment comment = new Comment();
        if (userRepository.findById(userId).isPresent() && postRepository.findById(postId).isPresent()) {

            comment.setCommentBody(reqCom);
            comment.setUser(userRepository.findById(userId).get());
            comment.setUpdatedAt(LocalDateTime.now());
            comment.setCreatedAt(LocalDateTime.now());
            comment.setPost(postRepository.findById(postId).get());
            commentRepository.save(comment);
        }
        return comment;
    }


    public List<String> comments(Long userId, Long postId) {
        if (userRepository.findById(userId).isPresent() && postRepository.findById(postId).isPresent()) {
            List<Comment> allComments = commentRepository.findAll();
            List<String> commentBodies = new ArrayList<>();
            for (Comment comment : allComments) {
                if (comment.getPost().getPostId() == postId) {
                    commentBodies.add(comment.getCommentBody());
                }
            }
            if (commentBodies.isEmpty()) {
                return null;
            }
            return commentBodies;
        }
        return null;
    }

}