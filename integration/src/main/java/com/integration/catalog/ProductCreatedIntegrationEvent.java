package com.integration.catalog;

import com.integration.IntegrationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreatedIntegrationEvent extends IntegrationEvent {
    public String productId;
    public String name;
    public double price;
    public int quantity;
}
