package com.ms.user.services;

import org.springframework.stereotype.Service;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel create(UserModel userModel) {

        if(userRepository.existsByEmail(userModel.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        return userRepository.save(userModel);
    }
}
