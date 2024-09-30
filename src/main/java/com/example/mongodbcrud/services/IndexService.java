package com.example.mongodbcrud.services;

import com.example.mongodbcrud.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.CompoundIndexDefinition;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void createNormalIndexes(){
        mongoTemplate.indexOps(Product.class).ensureIndex(new Index().on("name", Sort.Direction.ASC));
        mongoTemplate.indexOps(Product.class).ensureIndex(new Index().on("price", Sort.Direction.ASC));
    }

    public void createCompoundIndex() {
        CompoundIndexDefinition compoundIndex = new CompoundIndexDefinition(new org.bson.Document()
                .append("category", 1)
                .append("brand",1));
        mongoTemplate.indexOps(Product.class).ensureIndex(compoundIndex);
    }



}