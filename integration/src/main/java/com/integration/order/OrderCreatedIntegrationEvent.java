package com.integration.order;

import com.integration.IntegrationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderCreatedIntegrationEvent extends IntegrationEvent {
    private final UUID orderId;
    private final UUID userId;
    private final float totalAmount;
    private final List<OrderItem> items;
    private final OrderStatus status;

    public static class OrderItem {
        private final UUID productId;
        private final int quantity;
        private final float price;

        public OrderItem(UUID productId, int quantity, float price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
    }

    public enum OrderStatus {
        PENDING,
        COMPLETED,
        SHIPPED,
        CANCELLED
    }
}
