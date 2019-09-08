package com.hickory.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	ProductRepo repo;

	@GetMapping(path = "products")
	public List<Product> ListAllProduct() {

		List<Product> products = repo.findAll();
		return products;
	}
	
	@GetMapping(path="product/{pid}")
	public Product getProductbyId(@PathVariable("pid") int pid) {
		
		Product product= repo.findById(pid).orElse(new Product(0,"Data not found","")) ;
		return product;
		
	}
	
	@PostMapping(path ="product")
	public String updateProductbyId(@RequestBody Product product) {
		
		//repo.save(product);
		int pid=product.getPid();
		if (repo.existsById(pid))
		{
			repo.save(product);
			return "Successful";
		}
		else return "Can't find the Product";
		
			}

}
