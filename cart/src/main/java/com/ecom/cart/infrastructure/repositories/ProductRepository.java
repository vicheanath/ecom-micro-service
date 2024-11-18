package com.ecom.cart.infrastructure.repositories;

import com.ecom.cart.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
