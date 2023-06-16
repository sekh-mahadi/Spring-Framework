package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Instructor;
import io.mtech.hibernate.model.InstructorDetail;
import io.mtech.hibernate.model.Student;

public class DeleteInstructorDetailsDemo {

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

			// get the primary key
			int theId = 5;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// print associated instructor
			System.out.println("The associated instructor: "
			        + tempInstructorDetail.getInstructor());

			// now delete instructor details
			System.out.println("Deleting InstructorDetail: "
			        + tempInstructorDetail);
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.remove(tempInstructorDetail);
			// commit
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		}  finally {
			//Handle connection leak issue
			session.close();
			sessionFactory.close();
		}
	}


}
