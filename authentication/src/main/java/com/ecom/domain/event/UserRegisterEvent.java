package com.ecom.domain.event;

import com.ecom.shared.domain.DomainEvent;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class UserRegisterEvent implements DomainEvent {
    private final UUID userId;
    private final String username;
    private final String email;
    private final String role;

    public UserRegisterEvent(UUID userId, String username, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    @Override
    public Instant getOccurredOn() {
        return Instant.now();
    }

    @Override
    public void setOccurredOn(Instant occurredOn) {

    }
}
