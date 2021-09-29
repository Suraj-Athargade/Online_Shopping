package com.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProfileService {
	@Autowired
	ProfileDAO profileDAOImpl;
	
	   public void save(Profile profile)
	   {
		   profileDAOImpl.saveProfile(profile);
	   }
	   public List<Profile> getAll()
	   {
		   return profileDAOImpl.findAll();
	   }
	   public boolean update(Profile profile)
	   {
		  return  profileDAOImpl.update(profile);
	   }
	   public boolean  delete(int prid)
	   {
		   Profile profile=profileDAOImpl.findProfile(prid);
		   return profileDAOImpl.delete(profile);
	   }
}
