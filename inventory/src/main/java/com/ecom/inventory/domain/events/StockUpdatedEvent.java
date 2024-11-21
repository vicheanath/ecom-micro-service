package com.ecom.inventory.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockUpdatedEvent extends BaseDomainEvent {
    private final String productId;
    private final int quantity;
}
