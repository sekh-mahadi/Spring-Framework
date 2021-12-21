package io.mtech.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.mtech.spring.app.domain.Organization;

public class BeanFactoryApp {
	
	public static void main(String[] args) {
// create the application context (container)
		ApplicationContext ctx= new ClassPathXmlApplicationContext("beans-factory.xml");
		//create the bean
		Organization org=(Organization)ctx.getBean("myorg");
				
		//invoke the company via bean
		//System.out.println(org.corporateSlogan());
		
		//print Organization details
		System.out.println(org);
		
		
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
