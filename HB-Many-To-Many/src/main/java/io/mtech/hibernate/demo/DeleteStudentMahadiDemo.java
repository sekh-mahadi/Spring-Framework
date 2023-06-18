package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Course;
import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Review;
import io.mtech.hibernate.model.Student;

public class DeleteStudentMahadiDemo {

	public static void main(String[] args) {
		// Session Factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {
			// Start transaction
			session.beginTransaction();
			
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\nLoaded Student: "+tempStudent);
			//delete Course
			session.remove(tempStudent);
			
			// commit
			session.getTransaction().commit();
			System.out.println("Mtech: Done!");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
