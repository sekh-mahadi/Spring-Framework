package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Course;
import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// Session Factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {

			// Start transaction
			session.beginTransaction();
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// create some courses
			Course course1 = new Course("Computer Fundamentals-CS101");
			Course course2 = new Course("Linear Algebra-MAT-101");
			
			// add courses to instructor
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			
			//save the courses to db
			session.persist(course1);
			session.persist(course2);
			// commit
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
