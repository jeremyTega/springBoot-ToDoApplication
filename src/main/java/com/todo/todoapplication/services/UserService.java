package com.todo.todoapplication.services;

import com.todo.todoapplication.dtos.requests.UserLoginRequest;
import com.todo.todoapplication.dtos.requests.UserRegistrationRequest;
import com.todo.todoapplication.dtos.response.AuthResponse;
import com.todo.todoapplication.dtos.response.UserResponse;

public interface UserService {
        UserResponse register(UserRegistrationRequest request);

//    AuthResponse login(UserLoginRequest requst);
}
