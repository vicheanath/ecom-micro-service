package com.integration.catalog;

import com.integration.IntegrationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDeletedEventIntegrationEvent extends IntegrationEvent {
    public String productId;
}
