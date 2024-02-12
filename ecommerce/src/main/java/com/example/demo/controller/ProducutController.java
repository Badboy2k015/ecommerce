package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@Controller
@RequestMapping("product")
public class ProducutController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product pro) {
		return new ResponseEntity<Product>(service.saveProduct(pro), HttpStatus.CREATED);

	}
	

	@GetMapping("view")
	public List<Product> getAllEmployee() {
		return service.getAllProduct();
	}

	@PutMapping("/{productid}")
	public ResponseEntity<Product> UpdateProduct(@PathVariable("productid") int productid, @RequestBody Product pro) {
		return new ResponseEntity<Product>(service.updateProduct(pro, productid), HttpStatus.CREATED);
	}

	@GetMapping("/prooductid")
	public ResponseEntity<Product> getProductById(@PathVariable("productid") int productid, @RequestBody Product pro) {
		return new ResponseEntity<Product>(service.getProductById(productid), HttpStatus.OK);
	}

	@DeleteMapping("/{productid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("productid") int productid) {
		service.deleteProduct(productid);
		return new ResponseEntity<String>(" Record Deleted succesfully 👍...", HttpStatus.OK);
	}
	

}
