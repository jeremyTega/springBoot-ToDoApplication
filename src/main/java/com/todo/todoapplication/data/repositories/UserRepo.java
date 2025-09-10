package com.todo.todoapplication.data.repositories;

import com.todo.todoapplication.data.models.User;
import com.todo.todoapplication.dtos.response.UserResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {

//    Optional<User> findByUsername(String username);
//    Optional<User> findByEmail(String email);
}
