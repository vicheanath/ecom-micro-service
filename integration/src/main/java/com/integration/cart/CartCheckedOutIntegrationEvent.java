package com.integration.cart;

import com.integration.IntegrationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CartCheckedOutIntegrationEvent extends IntegrationEvent {
    private final UUID userId;
    private final UUID cartId;
    private final List<CartCheckOutItem> items;

    public static class CartCheckOutItem{
        private final UUID productId;
        private final int quantity;
        private final double price;

        public CartCheckOutItem(UUID productId, int quantity, double price){
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
    }
}
