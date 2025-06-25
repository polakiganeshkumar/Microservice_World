package com.ganeshPolaki.Product_Service.reposeitry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ganeshPolaki.Product_Service.model.Product;

public interface ProductReposetory 
extends MongoRepository<Product,Integer>{

}
