package com.ecom.cart.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.Data;

import java.util.UUID;

@Data
public class CartItemAddedEvent extends BaseDomainEvent {
    private final UUID cartId;
    private final UUID productId;
    private final int quantity;
    private final double price;

    public CartItemAddedEvent(UUID cartId, UUID productId, int quantity, double price) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
