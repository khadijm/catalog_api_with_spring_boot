package com.catalog.com.exceptions.category;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.catalog.com.exceptions.CatalogException;

@ControllerAdvice
@RestController
public class CategoryExceptionResponseHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UncaughtCategory.class)
	public final ResponseEntity<CatalogException> handleAllExceptions(Exception ex, WebRequest request) {
		CatalogException exceptionResponse = new CatalogException(new Date(),"somethin went wrong"
				, ex.getMessage());
		return new ResponseEntity<CatalogException>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CategoryNotFound.class)
	public final ResponseEntity<CatalogException> handleCategoryNotFoundException(CategoryNotFound ex, WebRequest request) {
		CatalogException exceptionResponse = new CatalogException(new Date(),
				"category not found", ex.getMessage());
		return new ResponseEntity<CatalogException>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CatalogException exceptionResponse = new CatalogException(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	

}
