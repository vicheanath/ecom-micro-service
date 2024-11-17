package com.ecom.application.Controllers;

import com.ecom.application.createrole.CreateNewRoleCommand;
import com.ecom.shared.application.BaseReponse;
import com.ecom.shared.application.Mediator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
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
