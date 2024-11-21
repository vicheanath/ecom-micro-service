package com.ecom.order.domain.events;

import com.ecom.order.domain.OrderItem;
import com.ecom.order.domain.OrderStatus;
import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderCreatedEvent extends BaseDomainEvent {
    private final UUID orderId;
    private final UUID userId;
    private final float totalAmount;
    private final List<OrderItem> items;
    private final OrderStatus status;



}
