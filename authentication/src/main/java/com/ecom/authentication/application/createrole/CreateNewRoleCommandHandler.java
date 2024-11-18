package com.ecom.authentication.application.createrole;
import com.ecom.authentication.domain.entity.Role;
import com.ecom.authentication.domain.repositories.RoleRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateNewRoleCommandHandler implements CommandHandler<CreateNewRoleCommand,Void> {
    private RoleRepository roleRepository;

    public CreateNewRoleCommandHandler(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Void handle(CreateNewRoleCommand command) {
        var role = roleRepository.findByName(command.getRoleName());
        if(role != null) {
            throw new IllegalArgumentException("Role already exists");
        }
        role = new Role(command.getRoleName());
        roleRepository.save(role);
        return null;
    }

}
