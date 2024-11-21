package com.ecom.cart.application.cartcheckout;

import com.ecom.cart.domain.CartItem;
import com.ecom.cart.domain.events.CartCheckedOutEvent;
import com.ecom.cart.domain.events.CartItemAddedEvent;
import com.ecom.cart.infrastructure.RabbitMqConfig;
import com.ecom.cart.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import com.integration.cart.CartCheckedOutIntegrationEvent;
import com.integration.cart.CartItemAddedIntegrationEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class CartCheckedOutEventPublisher {
    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public CartCheckedOutEventPublisher(RabbitMqIntegrationEventPublisher eventPublisher) {

        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener
    public void handle(CartCheckedOutEvent event) {

        CartCheckedOutIntegrationEvent integrationEvent = map(event);
        eventPublisher.publish(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, integrationEvent);
    }

    private CartCheckedOutIntegrationEvent map(CartCheckedOutEvent event) {
        return new CartCheckedOutIntegrationEvent(event.getUserId(), event.getCartId(), event.getItems().stream().map(this::map).toList());
    }

    private CartCheckedOutIntegrationEvent.CartCheckOutItem map(CartItem event) {
        return new CartCheckedOutIntegrationEvent.CartCheckOutItem(event.getProduct().getId(), event.getQuantity(), event.getProduct().getPrice());
    }
}
