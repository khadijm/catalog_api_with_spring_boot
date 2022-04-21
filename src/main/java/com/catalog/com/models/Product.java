package com.catalog.com.models;
import javax.persistence.*;

import com.catalog.com.dto.ProductDTO;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String name;
	private long quantity;
	private long price;


	@ManyToOne
	@JoinColumn(nullable = false)
	private Category category; 

	
	public Product(int id, String name, long quantity, long price, Category category) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public Product() {	
	}

	public ProductDTO toDTO() {
		return new ProductDTO(getId(), getName(), getQuantity(), getPrice());
	}
	public ProductDTO toD() {
		return new ProductDTO(getId(), getName(), getQuantity(), getPrice(), getCategory());
	}
	
}
