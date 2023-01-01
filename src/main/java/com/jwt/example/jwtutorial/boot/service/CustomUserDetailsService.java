package com.jwt.example.jwtutorial.boot.service;

import com.jwt.example.jwtutorial.user.domain.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetailsService {
    org.springframework.security.core.userdetails.User createUser(String username, User user);
}
