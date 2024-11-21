package com.ecom.cart.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CartItemAddedEvent extends BaseDomainEvent {
    private final UUID userId;
    private final UUID productId;
    private final int quantity;
}
