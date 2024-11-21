package com.ecom.caltalog.application.product.deleteproductbyid;

import com.ecom.caltalog.domain.events.ProductDeletedEvent;
import com.ecom.caltalog.infrastructure.RabbitMqConfig;
import com.ecom.caltalog.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import com.integration.catalog.ProductDeletedEventIntegrationEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class ProductDeletedEventPublisher {
    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public ProductDeletedEventPublisher(RabbitMqIntegrationEventPublisher eventPublisher) {

        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener
    public void handle(ProductDeletedEvent event) {

        ProductDeletedEventIntegrationEvent integrationEvent = map(event);
        eventPublisher.publish(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, integrationEvent);

    }

    private ProductDeletedEventIntegrationEvent map(ProductDeletedEvent event) {
        return new ProductDeletedEventIntegrationEvent(event.getProductId());
    }

}
