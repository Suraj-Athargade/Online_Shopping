package com.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface ProfileDAO {
	public void saveProfile(Profile profile);
	public Profile findProfile(int prid);
	public List<Profile> findAll();
	
	public boolean update(Profile profile);
	public boolean delete(Profile profile);
}
