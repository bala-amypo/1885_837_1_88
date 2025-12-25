package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.exception.*;
import com.example.demo.service.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository r, PasswordEncoder e) {
        this.repo = r;
        this.encoder = e;
    }

    public User register(User user) {
        if (repo.existsByEmail(user.getEmail()))
            throw new BadRequestException("Email exists");

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
