package com.ecom.application.Controllers;

import com.ecom.application.Commands.UserLoginCommand;
import com.ecom.application.Commands.UserRegisterCommand;
import com.ecom.application.responses.UserLoginResponse;
import com.ecom.application.responses.UserRegisterResponse;
import com.ecom.shared.application.CommandHandler;
import com.ecom.shared.application.CommandHandlerWithResponse;
import com.ecom.shared.application.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

   private final Mediator mediator;

   public AuthenticationController(Mediator mediator) {
       this.mediator = mediator;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterCommand command) {
        mediator.send(command);
        return ResponseEntity.ok(new UserRegisterResponse(command.getUsername(), command.getEmail()));
    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginCommand command)
    {
        UserLoginResponse response = mediator.send(command, UserLoginResponse.class);
        return ResponseEntity.ok(response);
    }
}
