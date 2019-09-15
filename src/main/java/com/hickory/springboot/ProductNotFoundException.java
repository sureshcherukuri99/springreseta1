package com.hickory.springboot;

public class ProductNotFoundException extends RuntimeException {
	
	   public ProductNotFoundException(Integer pId) {
	        super("Product id not found : " + pId);
	    }

}
