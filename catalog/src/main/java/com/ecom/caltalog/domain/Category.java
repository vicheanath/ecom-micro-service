package com.ecom.caltalog.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

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

    private Category(String id, String name, String description, Category parentCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
    }

    public static Category create(String id, String name, String description, Category parentCategory) {
        return new Category(id, name, description, parentCategory);
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void updateParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

}
