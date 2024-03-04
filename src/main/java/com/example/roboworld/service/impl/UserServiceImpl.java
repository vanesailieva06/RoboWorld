package com.example.roboworld.service.impl;

import com.example.roboworld.model.dto.UserRegisterDto;
import com.example.roboworld.model.dto.UsersViewDto;
import com.example.roboworld.model.entity.Role;
import com.example.roboworld.model.entity.User;
import com.example.roboworld.model.entity.enums.RoleType;
import com.example.roboworld.repository.RoleRepository;
import com.example.roboworld.repository.UserRepository;
import com.example.roboworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = modelMapper.map(userRegisterDto, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        Role role = new Role();
        role.setRoleType(RoleType.User);
        roleRepository.save(role);
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    @Override
    public List<UsersViewDto> getAll() {

        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UsersViewDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
