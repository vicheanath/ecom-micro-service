package com.ecom.authentication.domain.event;

import com.ecom.shared.domain.BaseDomainEvent;
import com.ecom.shared.domain.DomainEvent;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class UserRegisterEvent extends BaseDomainEvent {
    private final UUID userId;
    private final String username;
    private final String email;
    private final UUID role;

    public UserRegisterEvent(UUID userId, String username, String email, UUID role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;
    }

}
