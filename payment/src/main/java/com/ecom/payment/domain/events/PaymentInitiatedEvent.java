package com.ecom.payment.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PaymentInitiatedEvent extends BaseDomainEvent {
    private final UUID paymentId;
    private final UUID orderId;
    private final UUID userId;
    private final double amount;
    private final String status;
}
