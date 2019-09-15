package com.hickory.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hickory.springboot.exception.ProductNotFoundException;
import com.hickory.springboot.exception.Todo;

import javassist.NotFoundException;

@RestController
public class HomeController {

	@Autowired
	ProductService productService;
	@Autowired
	ProductRepo productRepo;

	@GetMapping(path = "sampleproducts")
	public List<Product> ListAllProduct() {

		List<Product> products = productRepo.findAll();
		return products;
	}

	@GetMapping(path = "product/{pid}")
	public Optional<Product> getProductbyId(@PathVariable(value = "pid", required = true) int pId) {

		return productService.retreiveProduct(pId);
}



	@PutMapping(path = "product")
	public ResponseEntity<Response> updateProductbyIdWithErrorHandling(@RequestBody(required = true) Product product) {
		Response response = new Response();
		try {
			productService.save(product);
			response.setMessage("Product update is Successful with PID " + product.getPid());
			response.setStatus(HttpStatus.OK);
		} catch (NotFoundException nfe) {
			response.setMessage(nfe.getMessage());
			response.setStatus(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(response, response.getStatus());
	}

	@PostMapping(path = "product/noerror")
	public String createProuct(@RequestBody(required = true) Product product) {

		int pId = product.getPid();
	    productService.create(product);
		return "Product created successfully with PID : "+pId;
		
		
	}

	@PostMapping(path = "product")
	public ResponseEntity<Response> createProuctWithErrorHandling(@RequestBody(required = true) Product product) {

		Response response = new Response();
		int pid = product.getPid();
		try {
			productService.create(product);
			response.setMessage("Product creation is Successful with PID: " + product.getPid());
			response.setStatus(HttpStatus.OK);
		} catch (InvalidDataAccessResourceUsageException e) {
			response.setMessage(e.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST);
			
			
		}
		;
		return new ResponseEntity<Response>(response, response.getStatus());
	}

	@DeleteMapping(path = "product/noerror/{pid}")
	public String deleteProduct(@PathVariable(value = "pid", required = true) int pid) {

		if (productRepo.existsById(pid)) {
			productRepo.deleteById(pid);
			return "Product deleted with PID :" + pid;

		} else
			return "Product not found with PID :" + pid;

	}

	@DeleteMapping(path = "product/{pid}")
	public ResponseEntity<Response> deleteProductWithErrorHandling(
			@PathVariable(value = "pid", required = true) int pid) {

		Response response = new Response();

		try {
			productService.drop(pid);
			response.setMessage("Product Dropped is Successful with PID ");
			response.setStatus(HttpStatus.OK);
		} catch (NotFoundException nfe) {
			response.setMessage(nfe.getMessage());
			response.setStatus(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Response>(response, response.getStatus());

	}

	@GetMapping(path = "/users/dummy-service")
	public Todo errorService() {
		throw new RuntimeException("Some Exception Occured");
	
		
	}
	@GetMapping("/hello")
	ResponseEntity<Response> hello() {
		HttpHeaders headers = new HttpHeaders();
	    headers.add("New-Header", "Header Testing");
	    return new ResponseEntity<Response>(new Response("Hello",HttpStatus.OK,400), headers, HttpStatus.OK);
	}
	
}
