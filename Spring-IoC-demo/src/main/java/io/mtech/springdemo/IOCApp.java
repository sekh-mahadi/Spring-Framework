package io.mtech.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp {

	public static void main(String[] args) {
        //create the application context (container)
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		// create bean
		Organization org = (Organization) ctx.getBean("myorg");

		// invoke the company slogan via bean
		org.corporateSlogan();
		// close the application context (container)
		//((ClassPathXmlApplicationContext) ctx).close();

	}

}
