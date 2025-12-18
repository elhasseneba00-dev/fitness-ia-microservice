package com.fitnessmicroservice.userservice.service;

import com.fitnessmicroservice.userservice.dto.RegisterRequest;
import com.fitnessmicroservice.userservice.dto.UserResponse;
import com.fitnessmicroservice.userservice.model.User;
import com.fitnessmicroservice.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUSer = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUSer.getId());
        userResponse.setFirstName(savedUSer.getFirstName());
        userResponse.setLastName(savedUSer.getLastName());
        userResponse.setEmail(savedUSer.getEmail());
        userResponse.setPassword(savedUSer.getPassword());
        userResponse.setCreatedAt(savedUSer.getCreatedAt());
        userResponse.setUpdatedAt(savedUSer.getUpdatedAt());

        return userResponse;
    }

    public UserResponse getUserProfile(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }
}
