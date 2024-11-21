package com.ecom.caltalog.application.product.deleteproductbyid;

import com.ecom.caltalog.infrastructure.repositories.ProductRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductByIdCommandHandler implements CommandHandler<DeleteProductByIdCommand, Void> {

    private final ProductRepository repository;

    public DeleteProductByIdCommandHandler(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void handle(DeleteProductByIdCommand command) {
        repository.findById(command.getId()).ifPresent(repository::delete);
        return null;
    }
}
