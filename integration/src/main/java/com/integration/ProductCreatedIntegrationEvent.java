package com.integration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreatedIntegrationEvent extends IntegrationEvent {
    public String id;
    public String name;
    public double price;
    public String imageUrl;
    public String categoryId;
}
