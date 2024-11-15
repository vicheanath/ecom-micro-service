package com.ecom.order.domain;

import com.ecom.shared.domain.ValueObject;
import lombok.Getter;

import java.util.UUID;
@Getter
public class OrderItem extends ValueObject {
    private UUID id;
    private UUID productId;
    private int quantity;
    private float unitPrice;

    private OrderItem(UUID id, UUID productId, int quantity, float unitPrice) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public static OrderItem create(UUID id, UUID productId, int quantity, float unitPrice) {
        return new OrderItem(id, productId, quantity, unitPrice);
    }
}
