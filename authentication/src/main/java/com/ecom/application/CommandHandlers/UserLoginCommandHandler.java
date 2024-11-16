package com.ecom.application.CommandHandlers;

import com.ecom.application.Commands.UserLoginCommand;
import com.ecom.application.responses.UserLoginResponse;
import com.ecom.domain.repositories.UserRepository;
import com.ecom.infrastructure.JWT.JWTGenerator;
import com.ecom.shared.application.CommandHandler;
import com.ecom.shared.application.CommandHandlerWithResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginCommandHandler implements CommandHandlerWithResponse<UserLoginCommand, UserLoginResponse> {
    private JWTGenerator jwtGenerator;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserLoginCommandHandler(JWTGenerator jwtGenerator, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jwtGenerator = jwtGenerator;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserLoginResponse handle(UserLoginCommand command) {
        var user = userRepository.findByUsername(command.getUsername());
        if (user != null && passwordEncoder.matches(command.getPassword(), user.getPassword())) {
            var roles = userRepository.findRoleListByUsername(command.getUsername());
            var token = jwtGenerator.generateToken(
                    user.getUsername(),
                    roles
            );
            return new UserLoginResponse(token, user.getUsername());
        }
        return null;
    }

    @Override
    public Class<UserLoginCommand> getSupportedCommand() {
        return UserLoginCommand.class;
    }
}
