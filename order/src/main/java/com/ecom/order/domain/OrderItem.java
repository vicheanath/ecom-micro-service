package com.ecom.order.domain;

import com.ecom.shared.domain.ValueObject;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem extends ValueObject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int quantity;

    @ManyToOne
    private Order order;

    private float price;

    private UUID productId;

    public OrderItem() {
    }

    public OrderItem( int quantity, float price, UUID productId) {

        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }

    public float getTotalPrice() {
        return quantity * price;
    }


}
