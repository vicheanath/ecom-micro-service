package com.ecom.cart.domain;

import com.ecom.shared.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class CartItem  {

        @Id
        private UUID id;

        @ManyToOne
        private Cart cart;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;
        private int quantity;
        private double price;

        public CartItem() {
        }

        private CartItem(int quantity, double price, Product product) {
            this.id = UUID.randomUUID();
            this.quantity = quantity;
            this.price = price;
            this.product = product;
        }

        public static CartItem create(int quantity, double price, Product product) {
            return new CartItem(quantity, price, product);
        }

        public void increaseQuantity(int quantity) {
            this.quantity += quantity;
        }

        public void decreaseQuantity(int quantity) {
            if (this.quantity - quantity < 0) {
                throw new IllegalArgumentException("Quantity can't be negative");
            }
            this.quantity -= quantity;
        }

        public double getTotal() {
            return this.price * this.quantity;
        }


}
