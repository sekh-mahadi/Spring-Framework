package io.mtech.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.mtech.spring.app.domain.Organization;

public class DISetterApp {
	
	public static void main(String[] args) {
// create the application context (container)
		ApplicationContext ctx= new ClassPathXmlApplicationContext("beans-dis.xml");
		//create the bean
		Organization org=(Organization)ctx.getBean("myorg");
		
		//invoke the company via bean
		System.out.println(org.corporateSlogan());
		
		//print Organization details
		System.out.println(org);
		System.out.println(org.corporateService());
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
