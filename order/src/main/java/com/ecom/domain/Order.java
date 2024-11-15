package com.ecom.domain;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Order extends BaseEntity<UUID>{

    private UUID id;

    private UUID customerId;

    private float totalAmount;

    private String status;

    private List<OrderItem> orderItems;


    public Order(UUID customerId, List<OrderItem> orderItems) {
        this.customerId = customerId;
        this.orderItems = orderItems;
    }
}
