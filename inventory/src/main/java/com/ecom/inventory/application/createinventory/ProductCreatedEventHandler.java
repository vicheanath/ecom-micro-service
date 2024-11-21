package com.ecom.inventory.application.createinventory;

import com.ecom.inventory.domain.Inventory;
import com.ecom.inventory.infrastructure.RabbitMqConfig;
import com.ecom.inventory.infrastructure.repositories.InventoryRepository;
import com.integration.ProductCreatedIntegrationEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductCreatedEventHandler  {

    private final InventoryRepository inventoryRepository;

    public ProductCreatedEventHandler(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void handle(ProductCreatedIntegrationEvent event) {
        var inventory = Inventory.create(UUID.randomUUID(), UUID.fromString(event.getId()),0,0);
        inventoryRepository.save(inventory);
    }

}
