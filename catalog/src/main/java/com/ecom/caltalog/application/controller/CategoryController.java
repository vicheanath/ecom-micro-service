package com.ecom.caltalog.application.controller;

import com.ecom.caltalog.application.category.createcategory.CreateCategoryCommand;
import com.ecom.caltalog.application.category.getallcategory.GetAllCategoryDto;
import com.ecom.caltalog.application.category.getallcategory.GetAllCategoryQuery;
import com.ecom.caltalog.application.category.updatecategory.UpdateCategoryCommand;
import com.ecom.shared.infrastructure.Mediator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final Mediator mediator;

    public CategoryController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public List<GetAllCategoryDto> getAllCategory() {
       return   mediator.ask(new GetAllCategoryQuery());
    }

    @PostMapping
    public void createCategory( @RequestBody CreateCategoryCommand command) {
        mediator.send(command);
     }

    @PutMapping
    public void updateCategory(@RequestBody UpdateCategoryCommand command) {
        mediator.send(command);
    }

}

