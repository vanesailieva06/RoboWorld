package com.example.roboworld.model.entity;


import com.example.roboworld.model.entity.enums.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    private RoleType roleType;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
