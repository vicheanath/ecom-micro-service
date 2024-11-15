package com.ecom.order.domain.events;

import com.ecom.shared.domain.DomainEvent;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class OrderCreatedEvent implements DomainEvent {
    private final UUID orderId;
    private final UUID customerId;
    private final float total;

    public OrderCreatedEvent(UUID orderId, UUID customerId, float total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.total = total;
    }

    @Override
    public Instant getOccurredOn() {
        return Instant.now();
    }
}
