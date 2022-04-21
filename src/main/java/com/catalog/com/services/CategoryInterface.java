package com.catalog.com.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.catalog.com.dto.CategoryDTO;


public interface CategoryInterface {
	  
	List<CategoryDTO>getallcategroy();
	CategoryDTO getparticularcategory(int id);
	void deletecategory(int categoryId);
	ResponseEntity<Object> creatcategory(CategoryDTO categorydto);
	void updatecategory( int categoryId, CategoryDTO categorydto);
	
}
