package com.ecom.caltalog.application.product.getallproduct;

import com.ecom.caltalog.infrastructure.repositories.ProductRepository;
import com.ecom.shared.application.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductQueryHandler implements QueryHandler<GetAllProductQuery, List<GetAllProductDto>> {

    private final ProductRepository productRepository;

    public GetAllProductQueryHandler(ProductRepository productRepository ) {
        this.productRepository = productRepository;
    }

    @Override
    public List<GetAllProductDto> handle(GetAllProductQuery query) {




        var products = productRepository.findAll();
        return products.stream()
                .map(product -> new GetAllProductDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getImageUrl(),
                        product.getPrice(),
                        new CategoryDto(
                                product.getCategory().getId(),
                                product.getCategory().getName(),
                                product.getCategory().getDescription()
                        )
                ))
                .toList();
    }
}
