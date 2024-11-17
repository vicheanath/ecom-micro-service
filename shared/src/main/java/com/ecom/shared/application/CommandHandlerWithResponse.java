package com.ecom.shared.application;

import org.springframework.stereotype.Component;

@Component
public interface CommandHandlerWithResponse<C extends Command, TResponse> {
    TResponse handle(C command);
    Class<C> getSupportedCommand();
}
