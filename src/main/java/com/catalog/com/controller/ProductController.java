package com.catalog.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.com.dto.ProductDTO;
import com.catalog.com.models.Product;
import com.catalog.com.services.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
	
	private ProductServiceImpl service;
	
	@Autowired
	public ProductController(ProductServiceImpl service) {
		this.service=service;
	}

	//save a new product
	@PostMapping("/category/{categoryid}")
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody Product product, @PathVariable("categoryid") int categoryid) {
		
		ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(service.addProduct(product, categoryid), 
				HttpStatus.CREATED);
		
		return response;
	}
	
	//modify an existing product
	@PutMapping("/{productid}/category/{categoryid}")
	public ResponseEntity<ProductDTO> editProduct(@RequestBody Product product,
			@PathVariable("productid") int productid, @PathVariable("categoryid") int categoryid) {
		
		ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(service.editProduct(product, productid, categoryid),
				HttpStatus.CREATED);
		
		
		return response;
	}
	
	//delete a product
	@DeleteMapping("/{productid}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("productid")int productid) {
		service.deleteProduct(productid);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	//view all products
	@GetMapping("/")
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		ResponseEntity<List<ProductDTO>> response = new ResponseEntity<List<ProductDTO>>(service.retrieveAllProducts(), HttpStatus.OK);
		
		return response;
	}
	
	//view a single product
	@GetMapping("/{productid}")
	public ResponseEntity<ProductDTO> getSingleProduct(@PathVariable("productid")int productid) {
		ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(service.retrieveProduct(productid), HttpStatus.OK);
		
		return response;
	}
	
}
