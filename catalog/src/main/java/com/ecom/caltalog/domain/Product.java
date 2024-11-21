package com.ecom.caltalog.domain;

import com.ecom.caltalog.domain.events.ProductCreatedEvent;
import com.ecom.caltalog.domain.events.ProductUpdatedEvent;
import com.ecom.shared.domain.AggregateRoot;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Document(collection = "products")
public class Product extends AggregateRoot<String> {

    @Id
    @GeneratedValue
    private String id;

    private String name;

    private String description;

    private double price;

    private String imageUrl;

    private int quantity;

    @DBRef
    private Category category;

    private Product(String id, String name, String description, double price, int qty, String imageUrl, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
        this.quantity = qty;
    }

    public static Product create(String id, String name, String description, int qty, double price, String imageUrl, Category category) {
        var product = new Product(id, name, description, price, qty, imageUrl, category);
        product.addDomainEvent(new ProductCreatedEvent(product.getId(), name, price, qty));
        return product;
    }

    public void update(String name, String description, double price, String imageUrl, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
        addDomainEvent(new ProductUpdatedEvent(this.id, price, quantity));
    }


}