package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.model.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("customer")
@Api(value = "CustomerController", description = "Description for Customer Controller")
public class CustomerController {

	
	@Autowired
	ProductService pservice;
	
	@PostMapping("findproducts")
	@ApiOperation(value="Find an product",httpMethod="POST")
	@ResponseBody
	public ResponseEntity<?> findProducts(int pid)
	{
		Product p=pservice.findProduct(pid);
	if(p!=null)
	{
		 return ResponseEntity.ok(p+"product found");
	}
	else
	{
		return new ResponseEntity("not found ",HttpStatus.BAD_REQUEST);
	}
	
	}
	@GetMapping("getproducts")
	  @ApiOperation(value = "Get  All Products ", httpMethod = "GET")

	public ResponseEntity<?> getAllProducts()
	{
		List<Product> productlist=pservice.getAll();
		return new ResponseEntity(productlist,HttpStatus.OK);
	}
	
}

