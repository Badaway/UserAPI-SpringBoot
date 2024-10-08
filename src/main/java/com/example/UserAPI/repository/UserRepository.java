package com.example.UserAPI.repository;

import com.example.UserAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> , CrudRepository<User,Integer> {

    @Override
    Optional<User> findById(Integer integer);
}

