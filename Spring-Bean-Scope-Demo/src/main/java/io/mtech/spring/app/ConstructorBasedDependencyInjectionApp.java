package io.mtech.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.mtech.spring.app.domain.Organization;
import io.mtech.spring.app.service.HumanResourceDept;

public class ConstructorBasedDependencyInjectionApp {

	public static void main(String[] args) {
// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-di-contructor-based.xml");
		// create the bean
		Organization org = (Organization) ctx.getBean("myorg");

		// invoke the company via bean
		System.out.println(org.corporateSlogan());

		// print Organization details
		HumanResourceDept hrDept = (HumanResourceDept)ctx.getBean("myhrdept");
		System.out.println(hrDept.hiringStatus(5500));
		System.out.println("\n\n"+hrDept);

		((ClassPathXmlApplicationContext) ctx).close();
	}
}
