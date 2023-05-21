package com.example.Blogging.Platform.API.repository;

import com.example.Blogging.Platform.API.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface IPostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUserUserName(String userName);
}