package org.logistic.pelasar.fi.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.logistic.pelasar.fi.model.Pallet;
import org.logistic.pelasar.fi.util.HibernateUtil;

public class PalletDao {
	
	public	SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	
	public PalletDao()	{
		
	}
	public Pallet getPalletById(long id) {
		
		Pallet pallet = new Pallet();
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
		return pallet;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pallet> getAllPallets() {
		
		List<Pallet> pallets = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			pallets = session.createQuery("from pallet p").list();
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
		return pallets;
	}
	
	public boolean savePallet(Pallet pallet) {
		
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(pallet);
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
	
	public boolean updatePallet(Pallet pallet) {
		
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(pallet);
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
	
	public boolean removePallet(long id) {
		
		Pallet pallet = new Pallet();
		pallet.setId(id);
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(pallet);
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
