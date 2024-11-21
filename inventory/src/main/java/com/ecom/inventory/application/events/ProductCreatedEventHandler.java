package com.ecom.inventory.application.events;

import com.ecom.inventory.domain.Stock;
import com.ecom.inventory.infrastructure.RabbitMqConfig;
import com.ecom.inventory.infrastructure.repositories.StockRepository;
import com.integration.catalog.ProductCreatedIntegrationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductCreatedEventHandler {
    private static final Logger logger = LogManager.getLogger(ProductCreatedEventHandler.class);
    private final StockRepository inventoryRepository;

    public ProductCreatedEventHandler(StockRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void handle(ProductCreatedIntegrationEvent event) {
        var inventory = Stock.create(UUID.randomUUID(), UUID.fromString(event.getProductId()), event.getQuantity(), 0);
        inventoryRepository.save(inventory);
        logger.info("Stock created for product with id: {}", event.getProductId());
    }

}
