package com.ecom.inventory.infrastructure.repositories;

import com.ecom.inventory.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
}
