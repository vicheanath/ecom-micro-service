package com.ecom.caltalog.infrastructure.repositories;

import com.ecom.caltalog.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Optional<Category> findByName(String name);
}
