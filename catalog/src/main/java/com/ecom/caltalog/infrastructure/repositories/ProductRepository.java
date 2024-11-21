package com.ecom.caltalog.infrastructure.repositories;


import com.ecom.caltalog.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, String> {

}
