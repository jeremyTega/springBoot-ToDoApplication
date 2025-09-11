package com.todo.todoapplication.data.repositories;

import com.todo.todoapplication.data.models.User;
import com.todo.todoapplication.dtos.response.UserResponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {
    Optional<User> findByEmail(@NotBlank(message = "user email needed") @Email() String email);

//    Optional<User> findByUsername(String username);
//    Optional<User> findByEmail(String email);
}
