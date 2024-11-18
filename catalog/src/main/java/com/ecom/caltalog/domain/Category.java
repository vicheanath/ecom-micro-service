package com.ecom.caltalog.domain;

import com.ecom.caltalog.infrastructure.JpaDomainEventInterceptor;
import jakarta.persistence.EntityListeners;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collection = "categories")
public class Category {

    @Id
    private String id;

    private String name;

    private String description;

    @DBRef(lazy = true)
    private List<Category> subCategories;

    @DBRef(lazy = true)
    private Category parentCategory;

    public Category() {
    }

    private Category(String name, String description, Category parentCategory) {
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
    }

    public static Category create(String name, String description, Category parentCategory) {
        return new Category(name, description, parentCategory);
    }

}
