package DBManagers;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Domain.Promo;
import Domain.PromoCode;

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
	

	
	@SuppressWarnings("deprecation")
	public PaginatedQueryResponse<PromoCode> getPaginatedPromoCodes(Promo promo, int page, int perPage){
		List<PromoCode> promoCodes = new ArrayList<PromoCode>();
		int numResults = 0;
		Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	        ScrollableResults scroll = session.createQuery("FROM PromoCode where promo_id = ?", PromoCode.class)
	        		.setParameter(0, promo.getId())
	        		.scroll(ScrollMode.SCROLL_SENSITIVE);
	        
	        scroll.last();
	        numResults = scroll.getRowNumber() + 1;
	        scroll.first();
	        scroll.scroll((page-1)*perPage);
	        System.out.println("Found promo codes: "+ numResults);
	        int i = 0;
	        while (perPage > i++) {
	        	promoCodes.add((PromoCode)scroll.get(0));
	        	if (!scroll.next())
	        		break;
	        }
	        scroll.close();
	        tx.commit();
	        
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	    }finally {
	
	    }
	    PaginatedQueryResponse<PromoCode> resp = new PaginatedQueryResponse<PromoCode>();
	    resp.setData(promoCodes);
	    resp.setNumRecords(numResults);
	    resp.setPageSize(perPage);
	    resp.setCurrentPage(page);
	    
	    return resp;
	}
	public Promo find(int id){
		Promo Promo = null;
		Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	        Promo = session.get(Promo.class, id);
	        tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	    }finally {
	
	    }
	    return Promo;
	}
	
}
