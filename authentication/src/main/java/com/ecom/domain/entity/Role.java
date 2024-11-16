package com.ecom.domain.entity;

import com.ecom.domain.entity.User;
import com.ecom.shared.domain.BaseEntity;
import com.ecom.shared.domain.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
public class Role {
    private UUID id;
    private  String name;
    private String permission;
    List<User> users;

    public Role(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
