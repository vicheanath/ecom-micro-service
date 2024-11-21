package com.ecom.caltalog.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductCreatedEvent extends BaseDomainEvent {
    public String id;
    public String name;
    public double price;
    public String imageUrl;
    public String categoryId;
}
