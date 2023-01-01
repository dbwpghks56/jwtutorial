package com.jwt.example.jwtutorial.user.web;

import com.jwt.example.jwtutorial.user.domain.model.User;
import com.jwt.example.jwtutorial.user.dto.request.RequestUserDto;
import com.jwt.example.jwtutorial.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody RequestUserDto userDto) {
        return new ResponseEntity<>(userService.signup(userDto), HttpStatus.OK);
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<User> getMyUserInfo() {
        return new ResponseEntity<>(userService.getMyUserWithAuthorities().get(), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUserInfo(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUserWithAuthorities(username).get(), HttpStatus.OK);
    }

}
