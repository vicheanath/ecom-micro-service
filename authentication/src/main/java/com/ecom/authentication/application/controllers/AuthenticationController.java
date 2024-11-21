package com.ecom.authentication.application.controllers;

import com.ecom.authentication.application.userregister.UserRegisterCommand;
import com.ecom.authentication.application.userlogin.UserLoginCommand;
import com.ecom.authentication.application.responses.UserLoginResponse;
import com.ecom.authentication.application.responses.UserRegisterResponse;
import com.ecom.shared.infrastructure.Mediator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final Mediator mediator;

   public AuthenticationController(Mediator mediator) {
       this.mediator = mediator;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@Valid @RequestBody UserRegisterCommand command) {
        mediator.send(command);
        return ResponseEntity.ok(new UserRegisterResponse(command.getUsername(), command.getEmail()));
    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginCommand command)
    {
        var response = mediator.send(command);
        if(response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }
}
