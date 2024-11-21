package com.ecom.inventory.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class StockItemEvent extends BaseDomainEvent {
    private final UUID productId;
    private final int quantity;
}
