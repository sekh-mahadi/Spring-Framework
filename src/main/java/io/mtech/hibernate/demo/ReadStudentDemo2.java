package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Student;

public class ReadStudentDemo2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = null;
		try {
			// Create 3 student Object
			System.out.println("Creating a new Object.....");
			Student student = new Student("Ariba", "Islam", "ariba@gmail.com");

			// Start transaction
			tr = session.beginTransaction();

			// save the student object
			System.out.println("Saving the student....");
			System.out.println(student);
			session.persist(student);
			tr.commit();

			// find out the student's id: primary key
			System.out.println("Saved Student generated Id: "
			        + student.getId());
			// now get a new session and start transaction
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with Id: " + student.getId());
			Student myStudent = session.get(Student.class, student.getId());

			System.out.println("Get Complete: " + myStudent);
			// commit
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
		} finally {
			sessionFactory.close();
		}
	}

}
