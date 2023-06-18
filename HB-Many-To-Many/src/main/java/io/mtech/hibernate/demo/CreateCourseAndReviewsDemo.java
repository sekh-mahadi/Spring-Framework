package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Course;
import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Review;
import io.mtech.hibernate.model.Student;

public class CreateCourseAndReviewsDemo {

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

			Course tempCourse = new Course("Social Scince -SS101");

			// add some reviews
			tempCourse.addReview(new Review("Great course....Loved It"));
			tempCourse.addReview(new Review("COol course....job well done."));
			tempCourse.addReview(new Review("what a dump course, You are an idiot."));

			// save the course ...and leverage the cascade all
			System.out.println("Saving the course....");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());

			session.save(tempCourse);
			// commit
			session.getTransaction().commit();
			System.out.println("Mtech: Done!");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
