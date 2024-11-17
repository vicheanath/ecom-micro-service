package com.ecom.application.createrole;

import com.ecom.application.createrole.CreateNewRoleCommand;
import com.ecom.domain.entity.Role;
import com.ecom.domain.repositories.RoleRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateNewRoleCommandHandler implements CommandHandler<CreateNewRoleCommand> {
    private RoleRepository roleRepository;

    public CreateNewRoleCommandHandler(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public void handle(CreateNewRoleCommand command) {
        var role = roleRepository.findByName(command.getRoleName());
        if(role != null) {
            throw new IllegalArgumentException("Role already exists");
        }
        role = new Role(command.getRoleName());
        roleRepository.save(role);
    }

    @Override
    public Class<CreateNewRoleCommand> getSupportedCommand() {
        return CreateNewRoleCommand.class;
    }
}
