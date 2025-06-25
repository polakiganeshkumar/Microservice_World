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



	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", discription='" + discription + '\'' +
				", price=" + price +
				'}';
	}

	public Product(String id, String name, String discription, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.price = price;
	}

	public Product(){

	}

}
