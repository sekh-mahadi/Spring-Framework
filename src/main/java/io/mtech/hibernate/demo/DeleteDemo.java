package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// Session Factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {
			
			// Start transaction
			session.beginTransaction();

			//get the primary key
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			// delete the Instructors
			if (tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				// Note: this will ALSO Delete associated details object
				// because of CascadeType.ALL

				session.remove(tempInstructor);
			}
			// commit
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}
	}


}
