package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	public Product saveProduct(Product  pro);// create
	public List<Product> getAllProduct();// view
	public Product getProductById(int productid);//particular view
	public Product updateProduct(Product pro,int productid);
	public void deleteProduct(int productid);

}
