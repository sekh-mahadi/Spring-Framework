package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Course;
import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Student;

public class DeleteCourseOneToManyDemo {

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
			// get the course from db
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);

			System.out.println("Deleting Course: " + tempCourse);

			session.remove(tempCourse);

			// commit
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
