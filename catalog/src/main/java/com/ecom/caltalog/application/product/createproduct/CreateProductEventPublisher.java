package com.ecom.caltalog.application.product.createproduct;

import com.ecom.caltalog.domain.events.ProductCreatedEvent;
import com.ecom.caltalog.infrastructure.RabbitMqConfig;
import com.ecom.caltalog.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import com.integration.catalog.ProductCreatedIntegrationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class CreateProductEventPublisher {
    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public CreateProductEventPublisher(RabbitMqIntegrationEventPublisher eventPublisher) {

        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener
    public void handle(ProductCreatedEvent event) {

        ProductCreatedIntegrationEvent integrationEvent = map(event);
        eventPublisher.publish(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, integrationEvent);
    }

    private ProductCreatedIntegrationEvent map(ProductCreatedEvent event) {
        return new ProductCreatedIntegrationEvent(event.getProductId(), event.getName(), event.getPrice(), event.getQuantity());
    }


}
