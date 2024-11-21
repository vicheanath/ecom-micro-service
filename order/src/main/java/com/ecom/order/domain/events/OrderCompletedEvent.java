package com.ecom.order.domain.events;

import com.ecom.order.domain.OrderStatus;
import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderCompletedEvent extends BaseDomainEvent {
    private final UUID orderId;
    private final UUID paymentId;
    private final OrderStatus status;
}
