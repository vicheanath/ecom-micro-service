package com.ecom.authentication.domain.entity;

import com.ecom.authentication.domain.event.UserRegisterEvent;
import com.ecom.order.infrastructure.JpaDomainEventInterceptor;
import com.ecom.shared.domain.AggregateRoot;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@Getter
@Entity
@EntityListeners(JpaDomainEventInterceptor.class)
public class User extends AggregateRoot<UUID> {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    private User( UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public void addRole(Role role) {
        roles.add(role);
    }

    public static User create(String username, String password, String email, Role role) {
        var user = new User(UUID.randomUUID(), username, password, email);
        user.addRole(role);
        user.addDomainEvent(new UserRegisterEvent(user.id, user.username, user.email, role.getId())
        );
        return user;
    }
}

