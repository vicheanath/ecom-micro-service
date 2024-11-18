package com.ecom.cart.infrastructure.repositories;

import com.ecom.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
}
