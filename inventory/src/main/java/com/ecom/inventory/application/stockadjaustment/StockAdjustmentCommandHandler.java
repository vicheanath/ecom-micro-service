package com.ecom.inventory.application.stockadjaustment;

import com.ecom.inventory.domain.StockAdjustment;
import com.ecom.inventory.infrastructure.repositories.InventoryRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class StockAdjustmentCommandHandler implements CommandHandler<StockAdjastmentCommand, Void> {

    private final InventoryRepository inventoryRepository;

    public StockAdjustmentCommandHandler(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Void handle(StockAdjastmentCommand command) {
        var inventory = inventoryRepository.findById(command.getInventoryId()).orElseThrow();
        var stockAdjustment = StockAdjustment.create(command.getQuantity(), command.getReason(), command.getDescription());
        inventory.adjustStock(stockAdjustment);
        inventoryRepository.save(inventory);
        return null;
    }
}
