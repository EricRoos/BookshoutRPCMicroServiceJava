package DBManagers;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Domain.Accounts.User;

public class UserManager {
	private Session session;
	SessionFactory factory;
	public UserManager(){
		factory = new Configuration().configure("accounts_hibernate.cfg.xml").buildSessionFactory();
		session = factory.openSession();
	}
	
	public void close(){
		session.close();
		factory.close();
	}
	
	public List<User> all(){
		List<User> users = null;
		Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	        users = session.createQuery("FROM User", User.class).getResultList();
	        tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	    }finally {
	
	    }
	    return users;
	}
	
	public User find(int id){
		User user = null;
		Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	        user = (User)session.get(User.class, id);
	        tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	    }finally {
	
	    }
	    return user;
	}
	
	public User create(String firstName, String lastName, String email){
		Transaction tx = null;
		User user = null;
		int userId;
	    try{
	       tx = session.beginTransaction();
	       user = new User(email, firstName, lastName);	       
	       userId = (Integer) session.save(user); 
	       user.setId(userId);
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace(); 
	    }finally {
	       
	    }
	    return user;	
	}
}
