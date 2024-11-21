package com.ecom.caltalog.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreatedEvent extends BaseDomainEvent {
    public String productId;
    public String name;
    public double price;
    public int quantity;
}
