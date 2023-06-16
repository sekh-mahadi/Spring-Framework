package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Student;

public class OneToOneDemo {

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
			// Create a student Object
			/*
			 * Instructor tempInstructor = new Instructor("Sekh", "Mahadi",
			 * "sekh@mtech.com"); InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("No Like No Comments", "LUV to Code");
			 */
			Instructor tempInstructor = new Instructor("Sekh", "Rupon", "rupon@mtech.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("No Like comments", "LUV to Code");
			
			// Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			// Start transaction
			session.beginTransaction();

			// Note: this will ALSO save the details object
			// because of CascadeType.ALL

			// save the instructor object
			System.out.println("Saving the Instructor...."+tempInstructor);
			session.persist(tempInstructor);
			// commit
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			sessionFactory.close();
		}
	}

}
