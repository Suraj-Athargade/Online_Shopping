package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.model.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("admin")
@Api(value = "AdmintController", description = "Description for Admin Controller")
public class AdminController {
	@Autowired
	ProductService service;
	
	@GetMapping("getproducts")
	  @ApiOperation(value = "Get  All Products ", httpMethod = "GET")

	public ResponseEntity<?> getAllProducts()
	{
		List<Product> productlist=service.getAll();
		return new ResponseEntity(productlist,HttpStatus.OK);
	}
	
	@PostMapping("saveproducts")
	 @ApiOperation(value = "Save an Product", httpMethod = "POST")
	public ResponseEntity<?> saveProducts(@RequestBody Product product)
	{
		service.save(product);
	   return ResponseEntity.ok(product+" saved");
	}
	
	
	@PostMapping("updateproducts")
	@ApiOperation(value="Update an product",httpMethod="POST")
	public ResponseEntity<?> updateProducts(Product product)
	{
	if(service.update(product))
	{
		 return ResponseEntity.ok(product +"product updated");
	}
	else
	{
		return new ResponseEntity("not updated ",HttpStatus.BAD_REQUEST);
	}
	
	}
	@PostMapping("deleteproducts")
	@ApiOperation(value="Delete an product",httpMethod="POST")
	public ResponseEntity<?> deleteProducts(int pid)
	{
	     service.delete(pid);
		 return ResponseEntity.ok(pid +"product deleted");
	}
	@PostMapping("findproducts")
	@ApiOperation(value="Find an product",httpMethod="POST")
	@ResponseBody
	public ResponseEntity<?> findProducts(int pid)
	{
		Product p=service.findProduct(pid);
	if(p!=null)
	{
		 return ResponseEntity.ok(p+"product found");
	}
	else
	{
		return new ResponseEntity("not found ",HttpStatus.BAD_REQUEST);
	}
	
	}
	
	
}

