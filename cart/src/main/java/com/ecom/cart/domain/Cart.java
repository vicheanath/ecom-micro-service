package com.ecom.cart.domain;

import com.ecom.cart.domain.events.CartCheckedOutEvent;
import com.ecom.cart.domain.events.CartItemAddedEvent;
import com.ecom.cart.infrastructure.JpaDomainEventInterceptor;
import com.ecom.shared.domain.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@EntityListeners(JpaDomainEventInterceptor.class)
public class Cart extends AggregateRoot<UUID> {

    @Id
    private UUID id;
    private UUID userId;
    @OneToMany
    @JoinColumn(name = "cart_id")
    private List<CartItem> items;


    public Cart() {
    }

    public Cart(UUID id, UUID userId) {
        this.id = id;
        this.userId = userId;
        this.items = new ArrayList<>();
    }

    public static Cart create(UUID id, UUID userId) {
        return new Cart(id, userId);
    }

    public void addCartItem(CartItem item) {
        var existingItem = this.items.stream()
                .filter(cartItem -> cartItem.getId().equals(item.getId()))
                .findFirst();
        if (existingItem.isPresent()) {
            existingItem.get().increaseQuantity(item.getQuantity());
        } else {
            this.items.add(item);
        }
        this.addDomainEvent(new CartItemAddedEvent(userId, item.getProduct().getId(), item.getQuantity()));
    }

    public void removeCartItem(CartItem item) {
        this.items.removeIf(cartItem -> cartItem.getId().equals(item.getId()));
    }

    public void clearCart() {
        this.items.clear();
    }

    public double getTotal() {
        return this.items.stream().mapToDouble(CartItem::getTotal).sum();
    }


    public void checkout() {
        addDomainEvent(new CartCheckedOutEvent(userId, id , items));
    }
}