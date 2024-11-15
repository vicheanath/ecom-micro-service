package com.integration;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderCreatedIntegrationEvent extends IntegrationEvent {
    private UUID orderId;
    private UUID customerId;
    private float total;

    public OrderCreatedIntegrationEvent(UUID orderId, UUID customerId, float total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.total = total;
    }
}
