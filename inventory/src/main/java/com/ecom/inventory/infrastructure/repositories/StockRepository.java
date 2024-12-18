package com.ecom.inventory.infrastructure.repositories;

import com.ecom.inventory.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {

    Optional<Stock> findByProductId(UUID productId);
}
