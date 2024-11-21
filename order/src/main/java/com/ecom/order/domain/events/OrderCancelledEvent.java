package com.ecom.order.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderCancelledEvent extends BaseDomainEvent {
    private final UUID orderId;
    private final String reason;
}
