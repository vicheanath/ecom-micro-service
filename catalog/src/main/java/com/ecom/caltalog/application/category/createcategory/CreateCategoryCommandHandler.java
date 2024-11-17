package com.ecom.caltalog.application.category.createcategory;

import com.ecom.caltalog.domain.Category;
import com.ecom.caltalog.infrastructure.repositories.CategoryRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand,Void> {

    private final CategoryRepository categoryRepository;

    public CreateCategoryCommandHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Void handle(CreateCategoryCommand command) {
        if (checkIfCommandIsValidByName(command)) {
            throw new RuntimeException("Category with name " + command.getName() + " already exists");
        }
        Category parent = null;
        if (command.getParentId() != null && !command.getParentId().isEmpty()) {
            parent = getParentCategory(command);
        }

        Category category = Category.create(command.getName(), command.getDescription(), parent);
        categoryRepository.save(category);
        return null;
    }

    private boolean checkIfCommandIsValidByName(CreateCategoryCommand command) {
       return categoryRepository.findByName(command.getName()).isPresent();
    }

    private Category getParentCategory(CreateCategoryCommand command) {
        return categoryRepository.findById(command.getParentId())
                .orElseThrow(() -> new RuntimeException("Parent category not found if you want to create root category please leave parentId empty"));
    }

}
