package org.logistic.pelasar.fi.dao;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.logistic.pelasar.fi.model.Order;
import org.logistic.pelasar.fi.util.HibernateUtil;

public class OrderDao {
	
	public	SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	
	public OrderDao()	{
		
	}
	public Order getOrderById(long id) {
		
		Order order = new Order();
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
		return order;
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		
		List<Order> orders = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			orders = session.createQuery("from Order o").list();
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
		return orders;
	}
	
	public boolean saveOrder(Order order) {
		
		order.setDelivery(Calendar.getInstance());
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(order);
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
	
	public boolean updateOrder(Order order) {
		
		order.setDelivery(Calendar.getInstance());
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(order);
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
	
	public boolean removeOrder(long id) {
		
		Order order = new Order();
		order.setId(id);
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(order);
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
