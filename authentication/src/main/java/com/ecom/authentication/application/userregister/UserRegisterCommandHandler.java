package com.ecom.authentication.application.userregister;

import com.ecom.authentication.domain.entity.User;
import com.ecom.authentication.domain.repositories.RoleRepository;
import com.ecom.authentication.domain.repositories.UserRepository;
import com.ecom.authentication.infrastructure.JpaDomainEventInterceptor;
import com.ecom.shared.application.CommandHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterCommandHandler implements CommandHandler<UserRegisterCommand, Void> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    private final JpaDomainEventInterceptor jpaDomainEventInterceptor;

    public UserRegisterCommandHandler(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, JpaDomainEventInterceptor jpaDomainEventInterceptor) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jpaDomainEventInterceptor = jpaDomainEventInterceptor;
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
        var newUser = User.create(
                command.getUsername(),
                passwordEncoder.encode(command.getPassword()),
                command.getEmail(),
                role
        );
        userRepository.save(newUser);
        return null;
    }


}
