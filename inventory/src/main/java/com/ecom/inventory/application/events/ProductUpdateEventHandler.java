package com.ecom.inventory.application.events;

import com.ecom.inventory.domain.Stock;
import com.ecom.inventory.infrastructure.RabbitMqConfig;
import com.ecom.inventory.infrastructure.repositories.StockRepository;
import com.integration.catalog.ProductCreatedIntegrationEvent;
import com.integration.catalog.ProductDeletedEventIntegrationEvent;
import com.integration.catalog.ProductUpdatedIntegrationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductUpdateEventHandler {
    private static final Logger logger = LogManager.getLogger(ProductUpdateEventHandler.class);
    private final StockRepository stockRepositoryRepository;

    public ProductUpdateEventHandler(StockRepository inventoryRepository) {
        this.stockRepositoryRepository = inventoryRepository;
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void handle(ProductUpdatedIntegrationEvent event) {
        var stock = stockRepositoryRepository.findByProductId(UUID.fromString(event.getProductId()));
        stock.ifPresent(value -> {
            value.syncStock(event.getQuantity());
            stockRepositoryRepository.save(value);
            logger.info("Stock updated for product with id: {}", event.getProductId());
        });
    }
}
