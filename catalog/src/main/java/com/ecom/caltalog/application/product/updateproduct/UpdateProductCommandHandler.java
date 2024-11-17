package com.ecom.caltalog.application.product.updateproduct;

import com.ecom.caltalog.domain.Category;
import com.ecom.caltalog.infrastructure.repositories.CategoryRepository;
import com.ecom.caltalog.infrastructure.repositories.ProductRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductCommandHandler implements CommandHandler<UpdateProductCommand,Void> {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public UpdateProductCommandHandler(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Void handle(UpdateProductCommand command) {
        productRepository.findById(command.getId())
                .ifPresent(product -> {
                    Category category = categoryRepository.findById(command.getCategoryId())
                            .orElseThrow(() -> new RuntimeException("Category not found"));
                    product.update(command.getName(), command.getDescription(), command.getPrice(), command.getImageUrl() , category);
                    productRepository.save(product);
                });
        return null;
    }
}
