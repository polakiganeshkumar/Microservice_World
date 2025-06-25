package com.ganeshPolaki.Product_Service.controller;

import java.lang.System.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ganeshPolaki.Product_Service.model.Product;
import com.ganeshPolaki.Product_Service.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService  service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		service.saveProduct(product);
		return ResponseEntity.status(200).body(product);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
		return ResponseEntity.status(200).body(product);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts=service.getAllProducts();
		return ResponseEntity.status(200).body(allProducts);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Product>> getAllProducts(@PathVariable("id") int productId) {
		List<Product> allProducts=service.getAllProducts();
		return ResponseEntity.status(200).body(allProducts);
	}
	
	@PatchMapping
	public ResponseEntity<List<Product>> bulkUpdate(@RequestBody List<Product> products) {
		List<Product> allProducts=service.updateSpecificProducts(products);
		return ResponseEntity.status(200).body(allProducts);
	}
	
}
