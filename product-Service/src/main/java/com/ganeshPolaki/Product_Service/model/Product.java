package com.ganeshPolaki.Product_Service.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="prduct")
public class Product {
	
	@Id 
	private String id;
	private String name; 
	private String discription;
	private BigDecimal price;
	

}
