package com.ecom.domain.entity;

import com.ecom.domain.event.UserRegisterEvent;
import com.ecom.infrastructure.JpaDomainEventInterceptor;
import com.ecom.shared.domain.AggregateRoot;
import com.ecom.shared.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
    public void addRole(Role role) {
        roles.add(role);
    }

    public static User createuser(String username, String password, String email) {
        var user = new User();
        user.username = username;
        user.password = password;
        user.email = email;
        user.addDomainEvent(
                new UserRegisterEvent(user.id, user.username, user.email, "USER")
        );
        return user;
    }
}

