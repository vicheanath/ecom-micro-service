package com.ecom.caltalog.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductUpdatedEvent extends BaseDomainEvent {
    public String productId;
    public double price;
    public int quantity;
}
