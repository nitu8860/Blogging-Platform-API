package com.example.Blogging.Platform.API.repository;

import com.example.Blogging.Platform.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);


}
