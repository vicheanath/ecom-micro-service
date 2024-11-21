package com.ecom.authentication.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Role {
    @ManyToMany(mappedBy = "roles")
    List<User> users;
    @Id
    private UUID id;
    private String name;
    private String permission;

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
