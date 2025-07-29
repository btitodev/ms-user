package com.ms.user.services;

import org.springframework.stereotype.Service;

import com.ms.user.models.UserModel;
import com.ms.user.produces.UserProducer;
import com.ms.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel create(UserModel userModel) {

        if (userRepository.existsByEmail(userModel.getEmail()))
            throw new IllegalArgumentException("Email already exists");

        var usermodel = userRepository.save(userModel);
        userProducer.publishMessageEmail(usermodel);
        return usermodel;
    }
}
