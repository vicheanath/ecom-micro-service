package com.ecom.order.infrastructure.repositories;

import com.ecom.order.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
