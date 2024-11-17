package com.ecom.caltalog.application.product.getproductbyid;

import com.ecom.caltalog.infrastructure.repositories.ProductRepository;
import com.ecom.shared.application.QueryHandler;
import org.springframework.stereotype.Service;

@Service
public class GetProductQueryHandler implements QueryHandler<GetProductByIdQuery, GetProductByIdDto> {

    private final ProductRepository productRepository;

    public GetProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public GetProductByIdDto handle(GetProductByIdQuery query) {
        return productRepository.findById(query.getId())
                .map(product -> new GetProductByIdDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getImageUrl(),
                        product.getPrice(),
                        product.getCategory().getName())
                )
                .orElseThrow(() -> new RuntimeException("Product not found"));

    }
}
