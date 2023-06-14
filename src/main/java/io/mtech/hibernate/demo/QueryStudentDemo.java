package io.mtech.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = null;
		try {
			// Start transaction
			tr = session.beginTransaction();
			// Query Student

			List<Student> theStudents = session.createQuery("from Student", Student.class).list();
			displayStudents(theStudents);
			
			System.out.println("====================================================");
			theStudents = session.createQuery("from Student s where s.firstName ='Sekh'", Student.class).list();
			displayStudents(theStudents);
			tr.commit();
			System.out.println("Done!");

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
		} finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		theStudents.forEach(System.out::println);
	}

}
