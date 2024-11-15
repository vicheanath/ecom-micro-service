package com.ecom.order.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "order_items")
@Data
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int quantity;

    @ManyToOne
    private OrderEntity order;

    private double unitPrice;
}
