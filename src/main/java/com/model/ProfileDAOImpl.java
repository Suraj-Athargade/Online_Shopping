package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProfileDAOImpl implements ProfileDAO{
	@Autowired 
	SessionFactory sessionFactory;
	@Override
	
	public void saveProfile(Profile profile) {
		Session session=sessionFactory.openSession(); 
		Transaction tx=session.beginTransaction();
		session.save(profile);
		session.flush();
		session.close();
		tx.commit();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Profile findProfile(int prid) {
		Session session=sessionFactory.openSession();
        Profile profile=session.get(Profile.class, prid);
        return profile;
	}

	@Override
	public List<Profile> findAll() {
		Session session=sessionFactory.openSession();
		List<Profile> profilelist=session.createQuery("select i from Profile i").list();
		// TODO Auto-generated method stub
		return profilelist;
	}

	@Override
	public boolean update(Profile profile) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(profile);
		session.flush();
		session.close();
		tx.commit();
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(Profile profile) {
		Session session=sessionFactory.openSession();
		session.delete(profile);
		session.flush();
		session.close();
		// TODO Auto-generated method stub
		return true;
	}

}
