package com.example.Blogging.Platform.API.controller;

import com.example.Blogging.Platform.API.model.User;
import com.example.Blogging.Platform.API.repository.IUserRepository;
import com.example.Blogging.Platform.API.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private IUserRepository userRepository;


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        if (userRepository.findByUserName(user.getUserName()) == null) {
            User savedUser = userService.createUser(user);
            return new ResponseEntity<>("User is added successfully with username-" + user.getUserName() + ",\nuserId-" + user.getUserId(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("User with username " + user.getUserName() + " already exist", HttpStatus.BAD_REQUEST);
    }



    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllUserNames() {
        List<String> usernames = userService.getAllUsernames();
        return ResponseEntity.ok(usernames);
    }


    @GetMapping("userName/{userName}")
    public ResponseEntity<String> findByUserName(@PathVariable String userName) {
        if (userService.findByUserName(userName) != null) {
            return new ResponseEntity<>(userService.findByUserName(userName).toString(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>("No such User exists in the database", HttpStatus.NOT_FOUND);
    }

    @GetMapping("userDetails/{userId}/{password}")
    public ResponseEntity<String> userDetails(@PathVariable Long userId, @PathVariable String password) {
        if (userRepository.findById(userId).isPresent()) {
            if (userRepository.findById(userId).get().getPassword().equals(password)) {
                return new ResponseEntity<>(userService.getUserDetails(userId).toString(), HttpStatus.FOUND);
            }else{
                return new ResponseEntity<>("Wrong password",HttpStatus.FORBIDDEN);
            }
        }
        return new ResponseEntity<>("User with user Id -" + userId + " doesn't exist in Blogger", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User user) {
        if (userRepository.findById(userId).isPresent()) {
            Optional<User> updatedUser= userService.updateUser(userId, user);
            return new ResponseEntity<>("user with userId" + updatedUser.get().getUserId() + " updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("user With UserId " + userId + " doesn't exist in the Blogger", HttpStatus.BAD_REQUEST);
    }
}