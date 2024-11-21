package com.ecom.payment.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PaymentCompletedEvent extends BaseDomainEvent {
    private final UUID paymentId;
    private final UUID orderId;
    private final String status;
}
