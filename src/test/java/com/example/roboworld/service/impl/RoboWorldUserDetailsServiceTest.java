package com.example.roboworld.service.impl;

import com.example.roboworld.model.entity.Role;
import com.example.roboworld.model.entity.User;
import com.example.roboworld.model.entity.enums.RoleType;
import com.example.roboworld.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

class RoboWorldUserDetailsServiceTest {

    private RoboWorldUserDetailsService roboWorldUserDetailsService;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp(){
        roboWorldUserDetailsService = new RoboWorldUserDetailsService(mockUserRepository);
    }


    @Test
    void userNotFound(){
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> roboWorldUserDetailsService.loadUserByUsername("user"));
    }


    @Test
    void userFound(){
        User user = createUser();

        when(mockUserRepository.findByUsername(user.getUsername())).thenReturn(
                Optional.of(user));

        UserDetails userDetails = roboWorldUserDetailsService.loadUserByUsername(user.getUsername());

        Assertions.assertNotNull(userDetails);

        Assertions.assertEquals(user.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(user.getPassword(), userDetails.getPassword());

        assertTrue(
                containsAuthority(userDetails, "ROLE_" + RoleType.Admin),
                "The user is not admin");
        assertTrue(
                containsAuthority(userDetails, "ROLE_" + RoleType.User),
                "The user is not user");
    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
        return userDetails
                .getAuthorities()
                .stream()
                .anyMatch(a -> expectedAuthority.equals(a.getAuthority()));
    }

    private User createUser() {
        User user = new User();
        user.setFullName("Admin Adminov");
        user.setUsername("Admincho");
        user.setEmail("111@12.bg");
        user.setPassword("1234");
        Role role = new Role();
        role.setRoleType(RoleType.User);
        Role role1 = new Role();
        role1.setRoleType(RoleType.Admin);
        user.setRoles(List.of(role, role1));
        return user;
    }
}