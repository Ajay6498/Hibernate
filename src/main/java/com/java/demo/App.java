package com.java.demo;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
/**
 * 10/10/2023
 *
 */
public class App {
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {

		// hibernate.cfg.xml --> this default name

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		/*************************Add Student********************************************/

		Student stud = new Student(101, "XXXX");
	    
		session.save(stud);

		/*************************Get Student by Id********************************************/
           
		Student s = session.get(Student.class, 102);
		System.out.println(s);
		
		// System.out.println(s.getId() +" "+s.getName());
		
		/*************************Get All Student********************************************/

		 
		 List<Student> ll= session.createCriteria(Student.class).list();
         System.out.println(ll);


		/*****************************Delete Student by Id****************************************/
 		  Student deleStudent = session.get(Student.class, 102);

		        // session.delete(deleStudent);

		session.flush();
		tr.commit();
	}

	
}
