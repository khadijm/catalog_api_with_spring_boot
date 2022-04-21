package com.catalog.com.exceptions.product;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.catalog.com.exceptions.CatalogException;

@RestController
@ControllerAdvice
public class ProductExceptionResponseHandler extends ResponseEntityExceptionHandler {

// handle any non-specific error
	@ExceptionHandler(UncaughtProductException.class)
	public final ResponseEntity<CatalogException> handleAnyProductException(Exception ex, WebRequest request)
			throws Exception {

		CatalogException productException = new CatalogException(new Date(), ex.getMessage(),
				"Fatal Error! Something went terribly wrong. Review your actions");

		return new ResponseEntity<CatalogException>(productException, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//handle exceptions for not found products
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<CatalogException> handleProductNotFoundException(Exception ex, WebRequest request)
			throws Exception {

		CatalogException productException = new CatalogException(new Date(), ex.getMessage(),
				"Verify that the specified product exists, or that the specified product id is correct");

		return new ResponseEntity<CatalogException>(productException, HttpStatus.NOT_FOUND);
	}

//handle exceptions for non-deleted products
	@ExceptionHandler(ProductNotDeletedException.class)
	public final ResponseEntity<CatalogException> handleProductNotDeletedException(Exception ex, WebRequest request)
			throws Exception {

		CatalogException productException = new CatalogException(new Date(), ex.getMessage(),
				"Fatal error! Could not delete product. Verify that the specified product exists,"
						+ " or that the specified product id is correct");

		return new ResponseEntity<CatalogException>(productException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
