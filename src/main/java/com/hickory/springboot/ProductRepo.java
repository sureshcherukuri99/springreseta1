package com.hickory.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

}
