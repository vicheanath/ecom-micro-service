package com.ecom.caltalog.infrastructure.repositories;


import com.ecom.caltalog.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
