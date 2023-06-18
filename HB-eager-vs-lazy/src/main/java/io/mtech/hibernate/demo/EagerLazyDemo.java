package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import io.mtech.hibernate.model.Course;
import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Student;

public class EagerLazyDemo {

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
			// Start trans action
			session.beginTransaction();
			// get the instructor from db
			int theId = 1;
			Query<Instructor> query = session.createQuery("select i from Instructor i "
			        + "JOIN FETCH i.courses "
			        + "where i.id=:theInstructorId", Instructor.class);

			query.setParameter("theInstructorId", theId);
			
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("Mtech Instructor: " + tempInstructor);

			// commit
			session.getTransaction().commit();
			session.close();
			
			System.out.println("\nMtech Instructor: " + tempInstructor.getCourses());

			System.out.println("Mtech: Done!");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
