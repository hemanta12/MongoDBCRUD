package com.example.mongodbcrud.repositories;

import com.example.mongodbcrud.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {}