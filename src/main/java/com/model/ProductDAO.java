package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ProductDAO {
	public void saveProduct(Product product);
	public Product findProduct(int pid);
	public List<Product> findAll();
	
	public boolean update(Product product);
	public boolean delete(int pid);
}

