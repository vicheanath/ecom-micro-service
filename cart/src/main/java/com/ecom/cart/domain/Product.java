package com.ecom.cart.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
public class Product {

    @Id
    private UUID id;

    private String name;

    private double price;

    public Product() {
    }

    private Product(UUID id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product create(UUID id, String name, double price) {
        return new Product(id, name, price);
    }


}
