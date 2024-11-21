package com.ecom.inventory.domain;


import com.ecom.shared.domain.ValueObject;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class StockAdjustment extends ValueObject {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    public Stock inventory;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private StockAdjustmentReason reason;
    @Column(columnDefinition = "TEXT")
    private String description;

    public StockAdjustment() {
    }

    private StockAdjustment(int quantity, StockAdjustmentReason reason, String description) {
        this.quantity = quantity;
        this.reason = reason;
        this.description = description;
    }

    public static StockAdjustment create(int quantity, StockAdjustmentReason reason, String description) {
        return new StockAdjustment(quantity, reason, description);
    }

}


