package com.ecom.inventory.application.stockadjaustment;

import com.ecom.inventory.domain.StockAdjustment;
import com.ecom.inventory.infrastructure.repositories.StockRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class StockAdjustmentCommandHandler implements CommandHandler<StockAdjastmentCommand, Void> {

    private final StockRepository stockRepositoryRepository;

    public StockAdjustmentCommandHandler(StockRepository inventoryRepository) {
        this.stockRepositoryRepository = inventoryRepository;
    }

    @Override
    public Void handle(StockAdjastmentCommand command) {
        var stock = stockRepositoryRepository.findById(command.getInventoryId()).orElseThrow();
        var stockAdjustment = StockAdjustment.create(command.getQuantity(), command.getReason(), command.getDescription());
        stock.adjustStock(stockAdjustment);
        stockRepositoryRepository.save(stock);
        return null;
    }
}
