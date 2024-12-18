package com.ecom.caltalog.application.product.createproduct;

import com.ecom.caltalog.domain.Category;
import com.ecom.caltalog.domain.Product;
import com.ecom.caltalog.infrastructure.JpaDomainEventInterceptor;
import com.ecom.caltalog.infrastructure.repositories.CategoryRepository;
import com.ecom.caltalog.infrastructure.repositories.ProductRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateProductCommandHandler implements CommandHandler<CreateProductCommand, Void> {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final JpaDomainEventInterceptor jpaDomainEventInterceptor;

    public CreateProductCommandHandler(ProductRepository productRepository, CategoryRepository categoryRepository, JpaDomainEventInterceptor jpaDomainEventInterceptor) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.jpaDomainEventInterceptor = jpaDomainEventInterceptor;
    }

    @Override
    public Void handle(CreateProductCommand command) {

        Category category = categoryRepository.findById(command.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = Product.create(
                UUID.randomUUID().toString(),
                command.getName(),
                command.getDescription(),
                command.getQuantity(),
                command.getPrice(),
                command.getImageUrl(),
                category);

        jpaDomainEventInterceptor.publishEvents(product);
        product.clearDomainEvents();
        productRepository.save(product);

        return null;
    }
}
