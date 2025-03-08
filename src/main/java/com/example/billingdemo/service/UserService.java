package com.example.billingdemo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.billingdemo.entity.User;
import com.example.billingdemo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Register User (without password encoding)
    public User registerUser(User user) {
        return userRepository.save(user);  
    }

    // Login User (Simple match without BCrypt)
    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }
}

