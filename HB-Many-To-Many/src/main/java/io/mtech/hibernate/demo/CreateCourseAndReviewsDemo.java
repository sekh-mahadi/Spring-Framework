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
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {
			// Start transaction
			session.beginTransaction();
			// Create a course

			Course tempCourse = new Course("Linear Algebra -LA-101");

			// save the course ...and leverage the cascade all
			System.out.println("Saving the course....");
			System.out.println(tempCourse);
			session.save(tempCourse);
			
			//create the students
			Student tempStudent1 = new Student("Sekh", "Mahadi", "sekh@mtech.com");
			Student tempStudent2 = new Student("Shekh", "Rupon", "rupon@mtech.com");

			//Add students to the courset
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the students
			System.out.println("Saving the students: ");
			session.persist(tempStudent1);
			session.persist(tempStudent2);
			System.out.println("Saved Students: "+tempCourse.getStudents() );
			// commit
			session.getTransaction().commit();
			System.out.println("Mtech: Done!");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
