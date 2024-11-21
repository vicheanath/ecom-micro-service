package com.ecom.cart.application.getcartbycustomerid;

import java.util.UUID;

public record GetCartByCustomerIdResponseDto(
        UUID id,
        UUID customerId,
        CartItemDo[] cartItems
) {
}

