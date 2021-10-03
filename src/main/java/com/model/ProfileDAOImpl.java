package com.model;
import java.util.ArrayList;
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
	public void saveProfile(Profile user) {
		Session session=sessionFactory.openSession(); 
		Transaction tx=session.beginTransaction();
		session.save(user);
		session.flush();
		session.close();
		tx.commit();
	}
	@Override
	public Profile findProfile(int prid) {
		Session session=sessionFactory.openSession();
        Profile user=session.get(Profile.class, prid);
        return user;
	}
	@Override
	public List<Profile> findAll() {
		Session session=sessionFactory.openSession();
		List<Profile> profilelist=session.createQuery("select i from Profile i").list();
		return profilelist;
	}
	@Override
	public boolean update(Profile user) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(user);
		session.flush();
		session.close();
		tx.commit();
		return true;
	}
	@Override
	public boolean delete(Profile user) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(user);
		session.flush();
		session.close();
		tx.commit();
		return false;
	}
	@Override
	public boolean delete1(int prid) {	
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Profile p=session.find(Profile.class,prid);
		session.delete(p);
		session.flush();
		session.close();
		tx.commit();
		return false;
	}	
	public String validateUser(Profile user) {
		int flag=0;
		List<Profile> list=new ArrayList<Profile>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		list=this.findAll();
		for(Profile u:list) {
			if(u.getPrid()==user.getPrid()) {
					if((u.getPremail()).equals((user.getPremail()))) {		
							if((u.getPrpassword()).equals((user.getPrpassword()))){
								
								flag=1;
								break;	
							}
						}
					}
				}	
		if(flag==1) {
tx.commit();
			return "Valid User";
		}
		else {
			this.saveProfile(user);
			tx.commit();
			return "New User Saved";
		}		
	}
}
