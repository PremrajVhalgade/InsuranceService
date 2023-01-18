package com.insurance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.insurance.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ResourceNotFoundException> resourceNotFoundHandler(
			ResourceNotFoundException resourceNotFoundException) {
		String resourceName = resourceNotFoundException.getResourceName();
		String fieldName = resourceNotFoundException.getFieldName();
		long fieldValue = resourceNotFoundException.getFieldValue();
		resourceNotFoundException.setResourceName(resourceName);
		resourceNotFoundException.setFieldName(fieldName);
		resourceNotFoundException.setFieldValue(fieldValue);
		return new ResponseEntity<ResourceNotFoundException>(resourceNotFoundException, HttpStatus.NOT_FOUND);

	}

}
