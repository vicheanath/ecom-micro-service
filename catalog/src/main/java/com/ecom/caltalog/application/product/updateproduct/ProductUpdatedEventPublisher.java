package com.ecom.caltalog.application.product.updateproduct;

import com.ecom.caltalog.domain.events.ProductUpdatedEvent;
import com.ecom.caltalog.infrastructure.RabbitMqConfig;
import com.ecom.caltalog.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import com.integration.catalog.ProductUpdatedIntegrationEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class ProductUpdatedEventPublisher {

    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public ProductUpdatedEventPublisher(RabbitMqIntegrationEventPublisher eventPublisher) {

        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener
    public void handle(ProductUpdatedEvent event) {

        ProductUpdatedIntegrationEvent integrationEvent = map(event);
        eventPublisher.publish(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, integrationEvent);
    }

    private ProductUpdatedIntegrationEvent map(ProductUpdatedEvent event) {
        return new ProductUpdatedIntegrationEvent(event.getProductId(), event.getPrice(), event.getQuantity());
    }


}
