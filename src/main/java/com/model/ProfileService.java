package com.model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProfileService {
	@Autowired
	ProfileDAO profileDAOImpl;
	   public void save(Profile user)
	   {
		   profileDAOImpl.saveProfile(user);
	   }
	   public List<Profile> getAll()
	   {
		   return profileDAOImpl.findAll();
	   }
	   public boolean update(Profile user)
	   {
		  return  profileDAOImpl.update(user);
	   }
	   public boolean  delete(Profile user)
	   {
		   return profileDAOImpl.delete(user);
	   }
	   public boolean  delete1(int prid)
	   {
		  Profile profile=profileDAOImpl.findProfile(prid);
	        return profileDAOImpl.delete1(prid);
	   }
	   public String validateUser(Profile user) {
			return profileDAOImpl.validateUser(user);
		}
}



