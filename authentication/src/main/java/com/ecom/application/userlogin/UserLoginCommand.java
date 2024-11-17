package com.ecom.application.userlogin;

import com.ecom.application.responses.UserLoginResponse;
import com.ecom.shared.application.Command;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginCommand implements Command<UserLoginResponse> {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UserLoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserLoginCommand() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
