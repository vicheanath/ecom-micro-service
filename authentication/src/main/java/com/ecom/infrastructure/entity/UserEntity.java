package com.ecom.infrastructure.entity;

import com.ecom.shared.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Entity
@Data
public class UserEntity extends BaseEntity<UUID>{
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String username;
    private String password;
    private String email;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roleList;

}
