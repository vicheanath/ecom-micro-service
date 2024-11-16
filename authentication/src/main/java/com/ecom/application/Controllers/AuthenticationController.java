package com.ecom.application.Controllers;

import com.ecom.application.Commands.UserRegisterCommand;
import com.ecom.application.responses.UserRegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterCommand command) {
        return ResponseEntity.ok(new UserRegisterResponse(command.getUsername(), command.getEmail()));
    }
}
