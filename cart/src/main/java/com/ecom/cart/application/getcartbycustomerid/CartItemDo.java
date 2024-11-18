package com.ecom.cart.application.getcartbycustomerid;

import java.util.UUID;

public record CartItemDo(
        UUID id,
        UUID productId,
        int quantity
) {
}
