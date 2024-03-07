package com.example.roboworld.util;

import com.example.roboworld.model.entity.Role;
import com.example.roboworld.model.entity.User;
import com.example.roboworld.model.entity.enums.RoleType;
import com.example.roboworld.repository.RoleRepository;
import com.example.roboworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestDataUserUtil {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User createTestUser(String username) {
        return createUser(username, List.of(RoleType.User));
    }

    public User createTestAdmin(String username) {
        return createUser(username, List.of(RoleType.Admin));
    }
    public User createTestLecturer(String username) {
        return createUser(username, List.of(RoleType.Lecturer));
    }


    private User createUser(String username, List<RoleType> roles) {

        List<Role> roleEntities = roleRepository.findAllByRoleTypeIn(roles);
        Role role = new Role();
        role.setRoleType(RoleType.User);
        roleRepository.save(role);

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setRoles(List.of(role));
        newUser.setPassword("1234");
        newUser.setEmail("example@com");
        newUser.setFullName("Test Testov");

        return userRepository.save(newUser);
    }

    public void cleanUp() {
        userRepository.deleteAll();
    }
}
