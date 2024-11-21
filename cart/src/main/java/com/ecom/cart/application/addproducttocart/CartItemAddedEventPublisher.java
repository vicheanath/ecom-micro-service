package com.ecom.cart.application.addproducttocart;

import com.ecom.cart.domain.events.CartItemAddedEvent;
import com.ecom.cart.infrastructure.RabbitMqConfig;
import com.ecom.cart.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import com.integration.cart.CartItemAddedIntegrationEvent;
import com.integration.catalog.ProductCreatedIntegrationEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class CartItemAddedEventPublisher {
    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public CartItemAddedEventPublisher(RabbitMqIntegrationEventPublisher eventPublisher) {

        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener
    public void handle(CartItemAddedEvent event) {

        CartItemAddedIntegrationEvent integrationEvent = map(event);
        eventPublisher.publish(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, integrationEvent);
    }

    private CartItemAddedIntegrationEvent map(CartItemAddedEvent event) {
        return new CartItemAddedIntegrationEvent(event.getUserId(), event.getProductId(), event.getQuantity());
    }
}
