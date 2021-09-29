package io.mtech.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorArgsApp {
	
	public static void main(String[] args) {
// create the application context (container)
		ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
		//create the bean
		Organization org=(Organization)ctx.getBean("myorg");
		
		//invoke the company via bean
		org.corporateMtech();
		
		//print Organization details
		System.out.println(org);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
