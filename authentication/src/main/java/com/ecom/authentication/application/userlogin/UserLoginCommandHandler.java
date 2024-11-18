package com.ecom.authentication.application.userlogin;

import com.ecom.authentication.domain.repositories.RoleRepository;
import com.ecom.authentication.domain.repositories.UserRepository;
import com.ecom.authentication.infrastructure.JWT.JWTGenerator;
import com.ecom.authentication.application.responses.UserLoginResponse;
import com.ecom.shared.application.CommandHandlerWithResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginCommandHandler implements CommandHandlerWithResponse<UserLoginCommand, UserLoginResponse> {
    private JWTGenerator jwtGenerator;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserLoginCommandHandler(JWTGenerator jwtGenerator, PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.jwtGenerator = jwtGenerator;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserLoginResponse handle(UserLoginCommand command) {
        var user = userRepository.findByUsername(command.getUsername());
        if (user != null && passwordEncoder.matches(command.getPassword(), user.getPassword())) {
           var roles = user.getRoles();
            var token = jwtGenerator.generateToken(
                    user.getUsername(),
                    roles
            );
            System.out.println("Token: " + token);
            return new UserLoginResponse(token, user.getUsername());
        }
        return null;
    }

    @Override
    public Class<UserLoginCommand> getSupportedCommand() {
        return UserLoginCommand.class;
    }
}
