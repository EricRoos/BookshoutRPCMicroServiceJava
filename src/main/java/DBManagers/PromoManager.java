package DBManagers;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Domain.Promos.Promo;

public class PromoManager {	
	private static Session sessionInstance;
	private Session session;
	
	public static void warm() {
		getSession();
	}
	private static Session getSession() {
		if(sessionInstance == null) {
			SessionFactory factory = new Configuration().configure("promos_hibernate.cfg.xml").buildSessionFactory();
			sessionInstance = factory.openSession();
		}
		return sessionInstance;
	}
	
	public PromoManager(){
		session = PromoManager.getSession();
	}
	
	
	public List<Promo> all(){
		List<Promo> Promos = null;
		Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	        Promos = session.createQuery("FROM Promo", Promo.class).getResultList();
	        tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	    }finally {
	
	    }
	    return Promos;
	}
	
	public Promo find(int id){
		Promo Promo = null;
		Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	        Promo = (Promo)session.get(Promo.class, id);
	        tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	    }finally {
	
	    }
	    return Promo;
	}
	
	public static void main(String[] args){
		PromoManager m = new PromoManager();
		System.out.println(m.find(1).getName());
	}
}
