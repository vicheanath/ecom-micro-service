package com.ecom.order.domain;

import com.ecom.shared.domain.BaseEntity;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Order extends BaseEntity<UUID> {

    private UUID id;

    private UUID customerId;

    private float totalAmount;

    private String status;

    private List<OrderItem> orderItems;


    private Order(UUID id , UUID customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public static Order create(UUID id, UUID customerId) {
        return new Order(id, customerId);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    private void calculateTotalAmount() {
        totalAmount = orderItems.stream().map(OrderItem::getUnitPrice).reduce(0f, Float::sum);
    }
}
