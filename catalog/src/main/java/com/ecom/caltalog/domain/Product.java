package com.ecom.caltalog.domain;

import com.ecom.caltalog.domain.events.ProductCreatedEvent;
import com.ecom.caltalog.infrastructure.JpaDomainEventInterceptor;
import com.ecom.shared.domain.AggregateRoot;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


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

    @DBRef
    private Category category;

    private Product(String id, String name, String description, double price, String imageUrl, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public static Product create(String id, String name, String description, double price, String imageUrl , Category category) {
        var product = new Product(id,name, description, price, imageUrl, category);
        product.addDomainEvent(new ProductCreatedEvent(product.getId(), name, price, imageUrl, category.getId()));
        return product;
    }

    public void update(String name, String description, double price, String imageUrl, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }


}