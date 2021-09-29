package com.model;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductDAOImpl implements ProductDAO {
	@Autowired 
	SessionFactory sessionFactory;
	@Override
	public void saveProduct(Product product) {
		Session session=sessionFactory.openSession(); 
		Transaction tx=session.beginTransaction();
		session.save(product);
		session.flush();
		session.close();
		tx.commit();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findProduct(int pid) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		 Product product=session.get(Product.class, pid);
		 tx.commit();
        return product;
	}

	@Override
	public List<Product> findAll() {
		Session session=sessionFactory.openSession();
		List<Product> productlist=session.createQuery("select i from Product i").list();
		// TODO Auto-generated method stub
		return productlist;
	}



	@Override
	public boolean update(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(product);
		session.flush();
		session.close();
		tx.commit();
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(int pid) {
		Session session=sessionFactory.openSession();
		session.delete(pid);
		session.flush();
		session.close();
		// TODO Auto-generated method stub
		return false;
	}

}
