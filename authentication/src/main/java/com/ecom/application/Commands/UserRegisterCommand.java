package com.ecom.application.Commands;

import com.ecom.domain.entity.Role;
import com.ecom.shared.application.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterCommand implements Command {
    @NotBlank
    private String username;
    @NotNull
   // @Lenght(min = 8)

    private String password;
    private String email;
    private String role;

    public UserRegisterCommand(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
