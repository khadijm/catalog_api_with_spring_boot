package com.catalog.com.exceptions.category;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFound extends RuntimeException{

	public CategoryNotFound(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	

}
