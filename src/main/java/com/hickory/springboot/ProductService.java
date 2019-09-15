package com.hickory.springboot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import com.hickory.springboot.exception.ProductNotFoundException;

import javassist.NotFoundException;


@Service
public class ProductService {

	
	@Autowired
	ProductRepo repo;
	
	public int save(Product product) throws NotFoundException  {
		int pid = product.getPid();
		if (repo.existsById(pid)) {
			repo.save(product);
			
		} else {
			throw new NotFoundException("Product not found with PID " + product.getPid());
		}
		return pid;
	}
	
	public int create(Product product) throws InvalidDataAccessResourceUsageException {
		int pid = product.getPid();
		if (!repo.existsById(pid)) {
			repo.save(product);
			
		} else {
			throw new InvalidDataAccessResourceUsageException("Product Already exists with PID: " + pid);
		}
		return pid;
	}
	public int drop(int pid) throws NotFoundException {
		
		if (repo.existsById(pid)) {
			repo.deleteById(pid);
			
		} else {
			throw new NotFoundException("Product not found with PID " + pid);
		}
		return pid;
	}

	public Optional<Product> retreiveProduct(int pId) {
		if (repo.existsById(pId))
		{
			return repo.findById(pId);
			
		}
		else throw new ProductNotFoundException(pId);
		
		}
}
