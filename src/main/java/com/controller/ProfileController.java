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
import com.model.Profile;
import com.model.ProfileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("profile")
@Api(value = "ProfileController", description = "Description for Profile Controller")
public class ProfileController {

	@Autowired
	ProfileService service;
	
	@GetMapping("getprofiles")
	  @ApiOperation(value = "Get  All Profiles ", httpMethod = "GET")

	public ResponseEntity<?> getAllprofiles()
	{
		List<Profile> profilelist=service.getAll();
		return new ResponseEntity(profilelist,HttpStatus.OK);
	}
	
	@PostMapping("saveprofile")
	 @ApiOperation(value = "Save an Profile", httpMethod = "POST")
	public ResponseEntity<?> saveProfiles(@RequestBody Profile profile)
	{
		service.save(profile);
	   return ResponseEntity.ok(profile+" saved");
	}
	
	
	@PostMapping("updateprofiles")
	@ApiOperation(value="Update an profile",httpMethod="POST")
	public ResponseEntity<?> updateProfiles(@RequestBody Profile profile)
	{
		String test=service.validateUser(profile);
		if(test.equals("Valid User")) {
	if(service.update(profile))
	{
		
		 return ResponseEntity.ok(profile +"profile updated");
	}
	else
	{
		return new ResponseEntity("not updated ",HttpStatus.BAD_REQUEST);
	}
	
	}
	
	else
	{
		return new ResponseEntity("not registered ",HttpStatus.BAD_REQUEST);
	}
	}
	@PostMapping("deleteprofile")
	@ApiOperation(value="Delete an profile",httpMethod="POST")
	public ResponseEntity<?> deleteProfile(int prid)
	{
	     service.delete1(prid);
		 return ResponseEntity.ok(prid +"profile deleted");
	}
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("getproducts")
	  @ApiOperation(value = "Get  All Products ", httpMethod = "GET")

	public ResponseEntity<?> getAllProducts()
	{
		List<Product> productlist=pservice.getAll();
		return new ResponseEntity(productlist,HttpStatus.OK);
	}
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
	@PostMapping("/validateusers")
	@ApiOperation(value = "Validate users", httpMethod = "POST")
	public ResponseEntity<?> validateUsers(@RequestBody Profile user)
	{
		String test=service.validateUser(user);
		if(test.equals("Valid User"))
	 return ResponseEntity.ok("validated");
		else
			return ResponseEntity.ok("New User Created");
	}
	
}






