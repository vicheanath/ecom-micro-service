package com.ecom.order.application.createorder;

import com.ecom.order.domain.events.OrderCreatedEvent;
import com.ecom.order.infrastructure.mapper.DomainToIntegrationEventMapper;
import com.ecom.order.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class OrderCreatedEventHandler {
    private final DomainToIntegrationEventMapper eventMapper;
    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public OrderCreatedEventHandler(DomainToIntegrationEventMapper eventMapper,
                               RabbitMqIntegrationEventPublisher eventPublisher) {
        this.eventMapper = eventMapper;
        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener
    public void handle(OrderCreatedEvent event) {
        var integrationEvent = eventMapper.toIntegrationEvent(event);
        eventPublisher.publish("order", "order.created", integrationEvent);
        System.out.println("Published integration event: " + integrationEvent.getClass().getSimpleName());
    }
}
