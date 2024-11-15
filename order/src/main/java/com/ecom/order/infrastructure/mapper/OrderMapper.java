package com.ecom.order.infrastructure.mapper;

import com.ecom.order.domain.Order;
import com.ecom.order.domain.OrderItem;
import com.ecom.order.infrastructure.entity.OrderEntity;
import com.ecom.order.infrastructure.entity.OrderItemEntity;
import com.ecom.shared.infrastructure.mapper.EntityMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper implements EntityMapper<Order, OrderEntity> {

    @Override
    public Order toEntity(OrderEntity entity) {
        return null;
    }

    @Override
    public OrderEntity toDomain(Order domain) {
        if (domain == null) return null;
        OrderEntity entity = new OrderEntity();
        entity.setId(domain.getId());
        entity.setCustomerId(domain.getCustomerId());
        entity.setTotalPrice(domain.getTotalAmount());
        entity.setStatus(domain.getStatus());
        entity.setOrderItems(domain.getOrderItems()
                .stream()
                .map(this::toOrderItemEntity)
                .collect(Collectors.toList())

        );
        return entity;
    }

    private OrderItemEntity toOrderItemEntity(OrderItem orderItem) {
        if (orderItem == null) return null;
        OrderItemEntity entity = new OrderItemEntity();
        entity.setQuantity(orderItem.getQuantity());
        entity.setUnitPrice(orderItem.getUnitPrice());
        return entity;
    }
}
