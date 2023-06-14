package io.mtech.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.mtech.hibernate.model.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// Session Factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {
			// Create 3 student Object
			System.out.println("Creating a new Object.....");
			Student student = new Student("Sekh", "Mahadi", "msekh36@gmail.com");
			Student student1 = new Student("Jhon", "Doe", "doe@gmail.com");
			Student student2 = new Student("Peter", "Brooks", "peter@gmail.com");

			// Start transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student....");
			session.persist(student);
			session.persist(student1);
			session.persist(student2);

			// commit
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			sessionFactory.close();
		}
	}

}
