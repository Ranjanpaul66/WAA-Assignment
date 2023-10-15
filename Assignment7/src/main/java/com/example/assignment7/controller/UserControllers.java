package com.example.assignment7.controller;

import com.example.assignment7.model.User;
import com.example.assignment7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserControllers {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping()
    public User registerNewUser(@RequestBody User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    @GetMapping()
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("authentication")
    public Authentication getAuthentication(Authentication authentication) {
        return authentication;
    }
}
