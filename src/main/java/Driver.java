import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DBManagers.UserManager;
import Domain.User;

public class Driver {
	public static void main(String[] args){
		/*
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		for(User u : UserManager.all(session)){
			System.out.println(u.getEmail());
		}

		User u = UserManager.find(session, 11);
		System.out.println(u.getEmail());
		session.close();
		factory.close();
		*/
	}
}
