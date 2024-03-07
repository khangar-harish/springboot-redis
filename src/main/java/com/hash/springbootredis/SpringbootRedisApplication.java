package com.hash.springbootredis;

import com.hash.springbootredis.entity.Product;
import com.hash.springbootredis.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringbootRedisApplication {

	@Autowired
	private ProductDAO productDAO;

	@PostMapping
	public Product save(@RequestBody Product product){
		return productDAO.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts(){
		return productDAO.findAll();
	}

	@GetMapping("/{id}")
	public Product getAllProducts(@PathVariable int id){
		return productDAO.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id){
		return productDAO.deleteProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisApplication.class, args);
	}

}
