package com.todo.todoapplication.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRequest {
    @NotBlank(message = "user email needed")
    @Email()
    private String email;

    @NotBlank(message = "password is needed")
    private String password;
}
