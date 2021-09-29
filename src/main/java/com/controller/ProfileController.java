package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("saveprofiles")
	 @ApiOperation(value = "Save an Profile", httpMethod = "POST")
	public ResponseEntity<?> saveProfiles(Profile profile)
	{
		service.save(profile);
	   return ResponseEntity.ok(profile+" saved");
	}
	
	
	@PostMapping("updateprofiles")
	@ApiOperation(value="Update an profile",httpMethod="POST")
	public ResponseEntity<?> updateProfiles(Profile profile)
	{
	if(service.update(profile))
	{
		 return ResponseEntity.ok(profile +"profile updated");
	}
	else
	{
		return new ResponseEntity("not updated ",HttpStatus.BAD_REQUEST);
	}
	
	}
	
}
