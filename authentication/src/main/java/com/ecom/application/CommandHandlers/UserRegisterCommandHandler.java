package com.ecom.application.CommandHandlers;

import com.ecom.application.Commands.UserRegisterCommand;
import com.ecom.domain.entity.Role;
import com.ecom.domain.entity.User;
import com.ecom.domain.repositories.RoleRepository;
import com.ecom.domain.repositories.UserRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRegisterCommandHandler implements CommandHandler<UserRegisterCommand> {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    public UserRegisterCommandHandler(UserRepository userRepository
    , RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public void handle(UserRegisterCommand command) {
        var role = roleRepository.findByName(command.getRole());
        if(role == null){
            role = new Role();
            role.setName(command.getRole());
            System.out.println("Role: " + role.getName());
            roleRepository.save(role);
        }
        User user = new User();
        user.setUsername(command.getUsername());
        var password = passwordEncoder.encode(command.getPassword());
        user.setPassword(password);
        user.setEmail(command.getEmail());
        user.addRole(role);
        userRepository.save(user);
    }

    @Override
    public Class<UserRegisterCommand> getSupportedCommand() {
        return UserRegisterCommand.class;
    }
}
