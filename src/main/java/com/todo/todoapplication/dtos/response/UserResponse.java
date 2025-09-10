package com.todo.todoapplication.dtos.response;

import com.todo.todoapplication.data.models.Role;
import lombok.Data;

import java.time.Instant;

@Data
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private Role role;
    private Instant createdAt;

}
