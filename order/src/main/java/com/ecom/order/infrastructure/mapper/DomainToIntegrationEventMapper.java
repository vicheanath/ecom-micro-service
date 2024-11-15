package com.ecom.order.infrastructure.mapper;

import com.ecom.order.domain.events.OrderCreatedEvent;
import com.integration.OrderCreatedIntegrationEvent;
import org.springframework.stereotype.Component;

@Component
public class DomainToIntegrationEventMapper {

    public OrderCreatedIntegrationEvent toIntegrationEvent(OrderCreatedEvent domainEvent) {
        return new OrderCreatedIntegrationEvent( domainEvent.getOrderId(), domainEvent.getCustomerId(), domainEvent.getTotal()

        );
    }
}