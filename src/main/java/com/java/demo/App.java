package com.java.demo;

 
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 10/10/2023
 *
 */
public class App {
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
 		 
		// hibernate.cfg.xml --> this default name

		org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
 		org.hibernate.Transaction tr=session.beginTransaction();
 		
 		
 		Student stud = new Student(102, "XXXX");

 		System.out.println(stud);

		session.save(stud);

		session.flush();
		tr.commit();
	}
}
