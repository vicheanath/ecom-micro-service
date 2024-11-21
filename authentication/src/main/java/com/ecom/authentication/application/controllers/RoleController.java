package com.ecom.authentication.application.controllers;

import com.ecom.authentication.application.createrole.CreateNewRoleCommand;
import com.ecom.shared.application.BaseReponse;
import com.ecom.shared.infrastructure.Mediator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/role")
public class RoleController {
    private Mediator mediator;

    public RoleController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/create")
    public BaseReponse<String> createRole(@RequestBody CreateNewRoleCommand command) {
        mediator.send(command);
        return new BaseReponse<>(200, "Role created successfully", null);
    }
}
