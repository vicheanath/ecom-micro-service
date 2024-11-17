package com.integration;

import lombok.Data;

@Data
public class ProductCreatedIntegrationEvent extends IntegrationEvent {
    public String id;
    public String name;
    public double price;
    public String imageUrl;
    public String categoryId;

    public ProductCreatedIntegrationEvent(String id, String name, double price, String imageUrl, String categoryId) {
    }
}
