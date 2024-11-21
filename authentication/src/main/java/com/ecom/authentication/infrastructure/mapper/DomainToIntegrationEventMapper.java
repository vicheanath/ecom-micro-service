package com.ecom.authentication.infrastructure.mapper;

import com.ecom.authentication.domain.event.UserRegisterEvent;
import com.integration.UserRegisterIntegrationEvent;
import org.springframework.stereotype.Component;

@Component
public class DomainToIntegrationEventMapper {

    public UserRegisterIntegrationEvent userRegisterEventToUserRegisterIntegrationEvent(UserRegisterEvent event) {
        return new UserRegisterIntegrationEvent(event.getUserId().toString(), event.getUsername(), event.getEmail(), event.getRole().toString());
    }

}