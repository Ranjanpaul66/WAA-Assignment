package com.example.assignment8.service.security;


import com.example.assignment8.dto.RegistrationDTO;
import com.example.assignment8.dto.UserDTO;

public interface UserService {

    public RegistrationDTO save(UserDTO u);

}
