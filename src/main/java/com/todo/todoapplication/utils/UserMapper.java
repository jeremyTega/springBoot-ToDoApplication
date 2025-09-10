package com.todo.todoapplication.utils;

import com.todo.todoapplication.data.models.Role;
import com.todo.todoapplication.data.models.User;
import com.todo.todoapplication.dtos.requests.UserRegistrationRequest;
import com.todo.todoapplication.dtos.response.UserResponse;

import java.time.Instant;

public class UserMapper {
    public static User convertToUser(UserRegistrationRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setRole(Role.USER);
        user.setCreatedAt(Instant.now());
        return user;
    }



    public static UserResponse convertToUserResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }

}
