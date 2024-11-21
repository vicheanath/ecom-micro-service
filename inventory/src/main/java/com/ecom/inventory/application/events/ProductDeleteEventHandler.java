package com.ecom.inventory.application.events;

import com.ecom.inventory.infrastructure.RabbitMqConfig;
import com.ecom.inventory.infrastructure.repositories.StockRepository;
import com.integration.catalog.ProductUpdatedIntegrationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductDeleteEventHandler {
    private static final Logger logger = LogManager.getLogger(ProductDeleteEventHandler.class);
    private final StockRepository stockRepositoryRepository;

    public ProductDeleteEventHandler(StockRepository inventoryRepository) {
        this.stockRepositoryRepository = inventoryRepository;
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void handle(ProductUpdatedIntegrationEvent event) {
        var stock = stockRepositoryRepository.findByProductId(UUID.fromString(event.getProductId()));
        stock.ifPresent(stockRepositoryRepository::delete);
        logger.info("Stock deleted for product with id: {}", event.getProductId());
    }
}
