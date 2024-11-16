package com.ecom.infrastructure.entity;

import com.ecom.shared.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends BaseEntity<UUID> {
    @Id
    private UUID id;
    private  String name;
    private String permission;
    @ManyToMany(mappedBy = "roleList")
    List<UserEntity> users;

    public RoleEntity(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
