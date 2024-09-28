package com.example.mongodbcrud.controllers;

import com.example.mongodbcrud.models.Product;
import com.example.mongodbcrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductControler {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct){
        return productRepository.findById(id).map(product->{
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setCategory(updatedProduct.getCategory());
            return productRepository.save(product);
        }).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        productRepository.deleteById(id);
    }
}