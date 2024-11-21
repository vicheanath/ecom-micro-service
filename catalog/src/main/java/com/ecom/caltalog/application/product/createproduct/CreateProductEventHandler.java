package com.ecom.caltalog.application.product.createproduct;

import com.ecom.caltalog.domain.events.ProductCreatedEvent;
import com.ecom.caltalog.infrastructure.RabbitMqConfig;
import com.ecom.caltalog.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import com.integration.ProductCreatedIntegrationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class CreateProductEventHandler {
    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public CreateProductEventHandler(RabbitMqIntegrationEventPublisher eventPublisher) {

        this.eventPublisher = eventPublisher;
    }
    @TransactionalEventListener
    public void handle(ProductCreatedEvent event) {

        ProductCreatedIntegrationEvent integrationEvent = map(event);
        eventPublisher.publish(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTING_KEY, integrationEvent);

    }

    private ProductCreatedIntegrationEvent map(ProductCreatedEvent event) {
        return new ProductCreatedIntegrationEvent(event.getId(), event.getName(), event.getPrice(), event.getImageUrl(), event.getCategoryId());
    }



}
