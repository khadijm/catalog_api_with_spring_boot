package com.catalog.com.services;

import java.util.List;

import com.catalog.com.dto.ProductDTO;
import com.catalog.com.models.Product;

public interface ProductService {

	void deleteProduct(int productid);

	List<ProductDTO> retrieveAllProducts();

	ProductDTO retrieveProduct(int productid);
	

	ProductDTO addProduct(Product product, int categoryid);

	ProductDTO editProduct(Product product, int productid, int categoryid);

}
