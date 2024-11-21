package com.integration;

import lombok.Data;

@Data
public class UserRegisterIntegrationEvent extends IntegrationEvent {
    private String userId;
    private String username;
    private String email;
    private String role;

    public UserRegisterIntegrationEvent(String userId, String username, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
