package com.ecom.shared.application;

import com.integration.IntegrationEvent;

public interface EventHandler<T extends IntegrationEvent> {
    void handle(T event);
}
