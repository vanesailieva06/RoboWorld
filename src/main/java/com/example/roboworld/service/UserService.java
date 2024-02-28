package com.example.roboworld.service;

import com.example.roboworld.model.dto.UserRegisterDto;
import com.example.roboworld.model.entity.User;

public interface UserService {
    User findByUsername(String username);

    void registerUser(UserRegisterDto userRegisterDto);
}
