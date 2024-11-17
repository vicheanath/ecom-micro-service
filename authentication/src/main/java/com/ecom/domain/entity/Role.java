package com.ecom.domain.entity;

import com.ecom.domain.entity.User;
import com.ecom.shared.domain.BaseEntity;
import com.ecom.shared.domain.ValueObject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Role {
    @Id
    private UUID id;
    private  String name;
    private String permission;
    @ManyToMany(mappedBy = "roles")
    List<User> users;

    public Role(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
