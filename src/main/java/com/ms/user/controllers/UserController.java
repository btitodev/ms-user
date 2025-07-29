package com.ms.user.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.dtos.ErrorResponse;
import com.ms.user.dtos.UserRecordDTO;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDTO, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userModel));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }
}
