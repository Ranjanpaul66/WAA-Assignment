package com.example.assignment8.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.assignment8.domain.User;
import com.example.assignment8.dto.RegistrationDTO;
import com.example.assignment8.dto.UserDTO;
import com.example.assignment8.service.security.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> addMember(@Validated @RequestBody UserDTO userDTO) {
        RegistrationDTO result = null;
        try {
            result = userService.save(userDTO);
        } catch(Exception ex) {
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
