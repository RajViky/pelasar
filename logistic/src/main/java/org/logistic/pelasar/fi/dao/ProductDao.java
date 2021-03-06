package org.logistic.pelasar.fi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.logistic.pelasar.fi.model.Product;
import org.logistic.pelasar.fi.util.HibernateUtil;

public class ProductDao {
	
	public	SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	
	public ProductDao()	{
		
	}
	public Product getProductById(long id) {
		
		Product product = new Product();
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
		//	order = (Order) session.createQuery("from Order o where o.id = :ID").setParameter("ID", id).uniqueResult();
			session.getTransaction().commit();
		}
		
		catch(Exception ex){
			if(session != null){
				session.getTransaction().rollback();
			}
		}
		
		finally {
			if (session != null) {
				session.close();
			}
		}
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		
		List<Product> products = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			products = session.createQuery("from pallet p").list();
			session.getTransaction().commit();
		}
		
		catch(Exception ex){
			if(session != null){
				session.getTransaction().rollback();
			}
		}
		
		finally {
			if (session != null) {
				session.close();
			}
		}
		return products;
	}
	
	public boolean saveProduct(Product product) {
		
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
	    }
	 	
		catch(Exception ex){
			if(session != null){
				session.getTransaction().rollback();
			}
			hasErrors = true;
		}
		
		finally {
			if (session != null) {
				session.close();
			}
		}
		return hasErrors;
	}
	
	public boolean updateProduct(Product product) {
		
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			
	    }
		
	 	catch(Exception ex){
			if(session != null){
				session.getTransaction().rollback();
			}
			hasErrors = true;
		}
		
		finally {
			if (session !=null) {
				session.close();
			}
		}
		return hasErrors;
	}
	
	public boolean removeProduct(long id) {
		
		Product product = new Product();
		//product.setId(id);
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
	    }
	 	
		catch(Exception ex){
			if(session != null){
				session.getTransaction().rollback();
			}
			hasErrors = true;
		}
		
		finally {
			if (session !=null) {
				session.close();
			}
		}
		return hasErrors;
	}
}
