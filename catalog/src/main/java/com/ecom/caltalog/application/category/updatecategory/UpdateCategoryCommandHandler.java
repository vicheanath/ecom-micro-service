package com.ecom.caltalog.application.category.updatecategory;

import com.ecom.caltalog.infrastructure.repositories.CategoryRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategoryCommandHandler implements CommandHandler<UpdateCategoryCommand, Void> {

    private final CategoryRepository categoryRepository;

    public UpdateCategoryCommandHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Void handle(UpdateCategoryCommand command) {
        var category = categoryRepository.findById(command.getId()).orElseThrow();

        category.update(command.getName(), command.getDescription());

        if (command.getParentId() != null) {
            var parent = categoryRepository.findById(command.getParentId()).orElseThrow();
            category.updateParentCategory(parent);
        }
        categoryRepository.save(category);
        return null;
    }
}
