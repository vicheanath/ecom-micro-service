package com.ecom.application.userregister;

import com.ecom.application.userregister.UserRegisterCommand;
import com.ecom.domain.entity.User;
import com.ecom.domain.repositories.RoleRepository;
import com.ecom.domain.repositories.UserRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterCommandHandler implements CommandHandler<UserRegisterCommand,Void> {


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
    public Void handle(UserRegisterCommand command) {
        var user = userRepository.findByUsername(command.getUsername());
        if (user != null) {
            throw new RuntimeException("User already exists");
        }
        user = userRepository.findByEmail(command.getEmail());
        if (user != null) {
            throw new RuntimeException("Email already exists");
        }
        var role = roleRepository.findById(command.getRoleId()).orElseThrow(
                () -> new RuntimeException("Role not found")
        );
        user = User.createuser(
                command.getUsername(),
                passwordEncoder.encode(command.getPassword()),
                command.getEmail()
        );
        user.addRole(role);
        userRepository.save(user);
        return null;
    }



}
