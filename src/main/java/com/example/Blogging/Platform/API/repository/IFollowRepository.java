package com.example.Blogging.Platform.API.repository;
import com.example.Blogging.Platform.API.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface IFollowRepository extends JpaRepository<Follow,Long> {


}