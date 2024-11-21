package com.integration.catalog;

import com.integration.IntegrationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductUpdatedIntegrationEvent extends IntegrationEvent {
    public String productId;
    public double price;
    public int quantity;
}
