package com.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface ProfileDAO {
	public void saveProfile(Profile user);
	public Profile findProfile(int prid);
	public List<Profile> findAll();	
	public boolean update(Profile user);
	public boolean delete(Profile user);
	public boolean delete1(int prid);
	public String validateUser(Profile user);
}
