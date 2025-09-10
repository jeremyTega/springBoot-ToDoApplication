package com.todo.todoapplication.services;

import com.todo.todoapplication.data.models.User;
import com.todo.todoapplication.data.repositories.UserRepo;
import com.todo.todoapplication.dtos.requests.UserRegistrationRequest;
import com.todo.todoapplication.dtos.response.UserResponse;
import com.todo.todoapplication.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.todo.todoapplication.utils.UserMapper.convertToUser;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo repository;


    public final EmailServiceImpl emailService;

    @Override
    public UserResponse register(UserRegistrationRequest request){
        User user =  convertToUser(request);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        User savedUser = repository.save(user);

        emailService.sendEmail(
                savedUser.getEmail(),
                "Welcome to TodoApp!",
                "Hi " + savedUser.getUsername() + ", welcome onboard "
        );
        return UserMapper.convertToUserResponse(savedUser);
    }
}
