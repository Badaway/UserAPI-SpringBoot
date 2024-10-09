package com.example.UserAPI.service;

import com.example.UserAPI.model.User;
import com.example.UserAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    @Value("${productapi.uri}")
    String uri;
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

        var resp=userRepository.findAll();

        if (response.isPresent())
            return new ResponseEntity<>( response, HttpStatus.OK);
        return new ResponseEntity<>( "user does not exist", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getAllUsers(){

        var response=userRepository.findAll();



        if (!response.isEmpty())
            return new ResponseEntity<>( response, HttpStatus.OK);
        return new ResponseEntity<>( "users empty ", HttpStatus.BAD_REQUEST);
    }

    /*
    public ResponseEntity<Object> getProductsByUser(int userId){


        ResponseEntity<String> responseEntity = null;
        ResponseEntity<Object> result=null;
        try {


            RestTemplate restTemplate=new RestTemplate();
            result= restTemplate.getForEntity(uri+userId+"/products",Object.class);
            return new ResponseEntity<>(result.getBody(),HttpStatus.OK);

        }
        catch(HttpClientErrorException e) {
            responseEntity = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
        }catch(HttpServerErrorException e) {
            responseEntity = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }catch(Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }
        return new ResponseEntity<>("ServerError", HttpStatus.INTERNAL_SERVER_ERROR);
    }

     */
    public ResponseEntity<Object> getProductsByUser(int userId){


       ;
        ResponseEntity<Object> result=null;



            RestTemplate restTemplate=new RestTemplate();
            result= restTemplate.getForEntity(uri+userId+"/products",Object.class);
            return new ResponseEntity<>(result.getBody(),HttpStatus.OK);


    }



}
