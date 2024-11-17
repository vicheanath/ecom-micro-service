package com.ecom.infrastructure.mapper;

import com.ecom.domain.event.UserRegisterEvent;
import com.integration.OrderCreatedIntegrationEvent;
import com.integration.UserRegisterIntegrationEvent;
import org.springframework.stereotype.Component;

@Component
public class DomainToIntegrationEventMapper {

  public UserRegisterIntegrationEvent userRegisterEventToUserRegisterIntegrationEvent(UserRegisterEvent event) {
    return new UserRegisterIntegrationEvent(event.getUserId().toString(), event.getUsername(), event.getEmail(), event.getRole());
  }
}