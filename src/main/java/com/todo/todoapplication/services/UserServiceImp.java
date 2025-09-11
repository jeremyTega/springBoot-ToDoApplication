package com.todo.todoapplication.services;

import com.todo.todoapplication.data.models.User;
import com.todo.todoapplication.data.repositories.UserRepo;
import com.todo.todoapplication.dtos.requests.UserLoginRequest;
import com.todo.todoapplication.dtos.requests.UserRegistrationRequest;
import com.todo.todoapplication.dtos.response.AuthResponse;
import com.todo.todoapplication.dtos.response.UserResponse;
import com.todo.todoapplication.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.todo.todoapplication.utils.UserMapper.convertToUser;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepository;


    public final EmailServiceImpl emailService;
    @Autowired
    private JwtService jwtService;

    @Override
    public UserResponse register(UserRegistrationRequest request){
        checkIfUserExists(request.getEmail());
        User user =  convertToUser(request);
         user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        User savedUser = userRepository.save(user);

        emailService.sendEmail(
                savedUser.getEmail(),
                "Welcome to TodoApp!",
                "Hi " + savedUser.getUsername() + ", welcome onboard "
        );
        return UserMapper.convertToUserResponse(savedUser);
    }

    private void checkIfUserExists(String email) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new RuntimeException("User with email " + email + " already exists");
        }
    }



    private User findExistingUser(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User  with this " + email + "not found"));
    }


    public User findExistingUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
    }




    @Override
    public AuthResponse login(UserLoginRequest request) {
       User user = findExistingUser(request.getEmail());
        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Wrong password");
        }
        String token = jwtService.generateToken(user.getId());
        UserResponse userResponse = UserMapper.convertToUserResponse(user);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setUser(userResponse);
        return authResponse;
    }
}
