package com.ecom.inventory.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class StockReservedEvent extends BaseDomainEvent {
    private final UUID orderId;
    private final List<StockItemEvent> items;
}

