package com.ecom.authentication.application.userregister;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterCommand implements Command<Void> {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20,message = "Username must be between 3 and 20 characters")
    private String username;
    @NotNull
    @Size(min = 6, max = 20,message = "Password must be between 6 and 20 characters")
    private String password;
    @Email(message = "Email is not valid")
    private String email;
    @NotNull(message = "Role is required")
    private UUID roleId;

    public UserRegisterCommand(String username, String password, String email, UUID roleId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }

    public UUID getRoleId() {
        return roleId;
    }
}
