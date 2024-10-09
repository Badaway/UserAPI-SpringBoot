package com.example.UserAPI.controller;

import com.example.UserAPI.model.User;
import com.example.UserAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        user.setCreated_at(LocalDate.now().toString());
        return userService.newUser(user);

    }
    @GetMapping ("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable int userId){
        return userService.getUser(userId);

    }

    @GetMapping ("/users")
    public ResponseEntity<Object> getUsers(){
        return userService.getAllUsers();

    }
    @GetMapping ("{userId}/products")
    public ResponseEntity<Object> getProductsByUserId(@PathVariable int userId){
        return userService.getProductsByUser(userId);

    }
}
