package com.ecom.caltalog.application.controller;

import com.ecom.caltalog.application.category.createcategory.CreateCategoryCommand;
import com.ecom.shared.infrastructure.Mediator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final Mediator mediator;

    public CategoryController(Mediator mediator) {
        this.mediator = mediator;
    }
        @PostMapping
    public void createCategory(CreateCategoryCommand command) {
        mediator.send(command);
     }
}

