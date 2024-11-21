package com.ecom.order.application.createorder;

import com.ecom.order.domain.events.OrderCreatedEvent;
import com.ecom.order.infrastructure.RabbitMqConfig;
import com.ecom.order.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import com.integration.order.OrderCreatedIntegrationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class OrderCreatedEventHandler {
    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public OrderCreatedEventHandler(RabbitMqIntegrationEventPublisher eventPublisher) {

        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener
    public void handle(OrderCreatedEvent event) {
        var integrationEvent = map(event);
        eventPublisher.publish(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, integrationEvent);
    }

    private OrderCreatedIntegrationEvent map(OrderCreatedEvent event) {
        return new OrderCreatedIntegrationEvent(event.getOrderId(), event.getUserId(), event.getTotalAmount(),
                event.getItems().stream().map(this::mapItem).toList()
                , OrderCreatedIntegrationEvent.OrderStatus.valueOf(event.getStatus().name())
        );
    }

    private OrderCreatedIntegrationEvent.OrderItem mapItem(com.ecom.order.domain.OrderItem item) {
        return new OrderCreatedIntegrationEvent.OrderItem(item.getProductId(), item.getQuantity(), item.getPrice());
    }
}
