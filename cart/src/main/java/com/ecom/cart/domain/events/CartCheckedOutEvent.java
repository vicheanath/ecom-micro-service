package com.ecom.cart.domain.events;

import com.ecom.cart.domain.CartItem;
import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CartCheckedOutEvent extends BaseDomainEvent {

    private final UUID userId;
    private final UUID cartId;
    private final List<CartItem> items;
}

