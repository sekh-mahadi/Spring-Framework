package io.mtech.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.mtech.spring.app.domain.Organization;

public class BeanScopeApp {
	
	public static void main(String[] args) {
// create the application context (container)
		ApplicationContext ctx= new ClassPathXmlApplicationContext("beans-scope.xml");
		//create the bean
		Organization org=(Organization)ctx.getBean("myorg");
		Organization org1=(Organization)ctx.getBean("myorg");
		org1.setPostalCode("1720");
		
		
		
		//invoke the company via bean
		//System.out.println(org.corporateSlogan());
		
		//print Organization details
		System.out.println(org);
		System.out.println(org1);
		
		if (org==org1) {
			System.out.println("Singleton Scope Test: org and org1 point to the same instance.");
		}
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
