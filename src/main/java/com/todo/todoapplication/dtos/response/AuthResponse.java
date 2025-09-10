package com.todo.todoapplication.dtos.response;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private UserResponse user;
}
