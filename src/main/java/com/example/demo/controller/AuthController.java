package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final UserServiceImpl userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserServiceImpl userService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        User user = new User(null, request.getName(),
                request.getEmail(), request.getPassword(), "RESIDENT");
        return userService.register(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userService.findByEmail(request.getEmail());
        String token = jwtTokenProvider.generateToken(
                user.getEmail(), user.getRole());
        return new LoginResponse(token);
    }
}
