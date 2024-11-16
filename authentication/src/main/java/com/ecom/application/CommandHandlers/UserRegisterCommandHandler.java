package com.ecom.application.CommandHandlers;

import com.ecom.application.Commands.UserRegisterCommand;
import com.ecom.domain.entity.User;
import com.ecom.domain.repositories.UserRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterCommandHandler implements CommandHandler<UserRegisterCommand> {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserRegisterCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void handle(UserRegisterCommand command) {
        User user = new User();
        user.setUsername(command.getUsername());
        var password = passwordEncoder.encode(command.getPassword());
        user.setPassword(password);
        user.setEmail(command.getEmail());
        user.setRoleList(command.getRoleList());
        userRepository.save(user);

    }
}
