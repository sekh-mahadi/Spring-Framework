package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// Session Factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {
			int studentId = 1001;
			// now get a new session and start transaction
			session.beginTransaction();
			// Retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Deleting Student.....");
			//session.remove(myStudent);

			session.createQuery("delete from Student  where id=1003").executeUpdate();

			// commit
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			sessionFactory.close();
		}
	}

}
