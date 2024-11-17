package com.ecom.application.createrole;

import com.ecom.shared.application.Command;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateNewRoleCommand implements Command<Void> {
    private String roleName;
    private String permission;

    public CreateNewRoleCommand(String roleName, String permission) {
        this.roleName = roleName;
        this.permission = permission;
    }
}
