package com.ecom.application.Commands;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.NotBlank;

public class UserLoginCommand implements Command {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UserLoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
