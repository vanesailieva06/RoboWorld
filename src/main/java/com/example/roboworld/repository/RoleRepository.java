package com.example.roboworld.repository;

import com.example.roboworld.model.entity.Role;
import com.example.roboworld.model.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByRoleTypeIn(List<RoleType> roles);
}
