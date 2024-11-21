package com.ecom.inventory.domain;

import com.ecom.inventory.domain.events.StockUpdatedEvent;
import com.ecom.inventory.infrastructure.JpaDomainEventInterceptor;
import com.ecom.shared.domain.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@EntityListeners(JpaDomainEventInterceptor.class)
public class Stock extends AggregateRoot<UUID> {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID productId;
    private int availableStock;
    private int reservedStock;
    @OneToMany
    @JoinColumn(name = "inventory_id")
    private List<StockAdjustment> stockAdjustments;

    public Stock() {
    }

    public Stock(UUID id, UUID productId, int availableStock, int reservedStock) {
        this.id = id;
        this.productId = productId;
        this.availableStock = availableStock;
        this.reservedStock = reservedStock;
    }

    public static Stock create(UUID id, UUID productId, int availableStock, int reservedStock) {
        return new Stock(id, productId, availableStock, reservedStock);
    }

    public void adjustStock(StockAdjustment stockAdjustment) {
        stockAdjustments.add(stockAdjustment);
        availableStock += stockAdjustment.getQuantity();
        addDomainEvent(new StockUpdatedEvent(id.toString(), stockAdjustment.getQuantity()));
    }

    public void reserveStock(int quantity) {
        if (availableStock < quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        availableStock -= quantity;
        reservedStock += quantity;
    }

    public void releaseStock(int quantity) {
        if (reservedStock < quantity) {
            throw new IllegalArgumentException("Not enough stock reserved");
        }
        availableStock += quantity;
        reservedStock -= quantity;
    }
}
