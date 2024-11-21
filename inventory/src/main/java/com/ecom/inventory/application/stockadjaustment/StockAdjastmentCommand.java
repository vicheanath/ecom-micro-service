package com.ecom.inventory.application.stockadjaustment;

import com.ecom.inventory.domain.StockAdjustmentReason;
import com.ecom.shared.application.Command;
import jakarta.validation.constraints.Max;
import lombok.Data;

import java.util.UUID;

@Data
public class StockAdjastmentCommand implements Command<Void> {
    private UUID inventoryId;
    private int quantity;
    private StockAdjustmentReason reason;
    @Max(500)
    private String description;
}
