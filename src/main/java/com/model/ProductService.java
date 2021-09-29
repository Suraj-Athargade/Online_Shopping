package com.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
	@Autowired
	ProductDAO productDAOImpl;
	
	   public void save(Product product)
	   {
		   productDAOImpl.saveProduct(product);
	   }
	   public List<Product> getAll()
	   {
		   return productDAOImpl.findAll();
	   }
	   public boolean update(Product product)
	   {
		  return  productDAOImpl.update(product);
	   }
	   public boolean  delete(int pid)
	   {
		  Product product=findProduct(pid);
	        return productDAOImpl.delete(pid);
		   //Product product=productDAOImpl.findProduct(pid);
		   //return productDAOImpl.delete(pid);
	   }
	   public Product findProduct(int pid) {
		// Product product=productDAOImpl.findProduct(pid);
		  return productDAOImpl.findProduct(pid);
	  }

}
