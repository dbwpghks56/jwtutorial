package com.jwt.example.jwtutorial.user.service;

import com.jwt.example.jwtutorial.user.domain.model.User;
import com.jwt.example.jwtutorial.user.dto.request.RequestUserDto;

import java.util.Optional;

public interface UserService {

    User signup(RequestUserDto userDto);
    Optional<User> getUserWithAuthorities(String username);

    Optional<User> getMyUserWithAuthorities();
}
