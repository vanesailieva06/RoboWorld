package com.example.roboworld.service;

import com.example.roboworld.model.dto.UserRegisterDto;
import com.example.roboworld.model.dto.UsersViewDto;
import com.example.roboworld.model.entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    void registerUser(UserRegisterDto userRegisterDto);

    List<UsersViewDto> getAll();

    void deleteUser(Long id);
}
