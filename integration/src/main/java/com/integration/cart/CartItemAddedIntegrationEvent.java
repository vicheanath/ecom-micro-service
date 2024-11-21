package com.integration.cart;

import com.integration.IntegrationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CartItemAddedIntegrationEvent extends IntegrationEvent {
    private final UUID userId;
    private final UUID productId;
    private final int quantity;
}
