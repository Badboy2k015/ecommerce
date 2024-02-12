package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repos;

	public ProductServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.repos = repos; 
	}

	@Override
	public Product saveProduct(Product pro) {
		// TODO Auto-generated method stub
		return repos.save(pro);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public Product getProductById(int productid) {
		// TODO Auto-generated method stub
		return repos.findById(productid).orElseThrow(() -> new IdNotFoundException ("invalid ID "));
	}

	@Override
	public Product updateProduct(Product pro, int productid) {
		// TODO Auto-generated method stub
		Product obj = repos.findById(productid)
				.orElseThrow(() -> new IdNotFoundException("invalid ID"));
		obj.setProductid(productid);
		obj.setName(pro.getName());
		obj.setDescription(pro.getDescription());
		obj.setPrice(pro.getPrice());
		obj.setQuantityAvailable(pro.getQuantityAvailable());
		Product save = repos.save(obj);
		return save;
	}

	@Override
	public void deleteProduct(int productid) {
		// TODO Auto-generated method stub
		Product obbj = repos.findById(productid)
				.orElseThrow(() -> new IdNotFoundException("invalid ID"));
		repos.delete(obbj);
		
	}

}
