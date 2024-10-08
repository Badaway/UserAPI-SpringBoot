package com.example.UserAPI.service;

import com.example.UserAPI.model.User;
import com.example.UserAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> newUser(User user){
        userRepository.save(user);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    public ResponseEntity<Object> getUser(int id){

        var response=userRepository.findById(id);

        if (response.isPresent())
            return new ResponseEntity<>( response, HttpStatus.OK);
        return new ResponseEntity<>( "user does not exist", HttpStatus.BAD_REQUEST);
    }


}
