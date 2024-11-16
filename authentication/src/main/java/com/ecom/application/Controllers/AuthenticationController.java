package com.ecom.application.Controllers;

import com.ecom.application.Commands.UserLoginCommand;
import com.ecom.application.Commands.UserRegisterCommand;
import com.ecom.application.responses.UserLoginResponse;
import com.ecom.application.responses.UserRegisterResponse;
import com.ecom.shared.application.CommandHandler;
import com.ecom.shared.application.CommandHandlerWithResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private CommandHandler<UserRegisterCommand> userRegisterCommandHandler;
    private CommandHandlerWithResponse<UserLoginCommand,UserLoginResponse> userLoginCommandHandler;

    public AuthenticationController(CommandHandler<UserRegisterCommand> userRegisterCommandHandler
    , CommandHandlerWithResponse<UserLoginCommand,UserLoginResponse> userLoginCommandHandler) {
        this.userRegisterCommandHandler = userRegisterCommandHandler;
        this.userLoginCommandHandler = userLoginCommandHandler;
    }
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterCommand command) {
        userRegisterCommandHandler.handle(command);
        return ResponseEntity.ok(new UserRegisterResponse(command.getUsername(), command.getEmail()));
    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginCommand command)
    {
        var response = userLoginCommandHandler.handle(command);
        if(response == null)
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }
}
