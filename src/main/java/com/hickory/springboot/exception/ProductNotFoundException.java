package com.hickory.springboot.exception;

public class ProductNotFoundException extends RuntimeException {
	
	   public ProductNotFoundException(Integer pId) {
	        super("Product not found with Product ID : " + pId);
	    }

}
