package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Course;
import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Review;
import io.mtech.hibernate.model.Student;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		// Session Factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {
			// Start transaction
			session.beginTransaction();
			// Create a course
			// get the course
			int theId = 13;
			Course tempCourse = session.get(Course.class, theId);
			// print the course
			System.out.println("Deleting the course.....");
			System.out.println(tempCourse);

			// print the course reviews
			System.out.println(tempCourse.getReviews());
			// delete the course
			session.remove(tempCourse);
			// commit
			session.getTransaction().commit();
			System.out.println("Mtech: Done!");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
