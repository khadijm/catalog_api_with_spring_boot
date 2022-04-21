package com.catalog.com.exceptions.category;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CategoryNotDelete extends RuntimeException {
	public CategoryNotDelete(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
