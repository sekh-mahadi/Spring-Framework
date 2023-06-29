package io.mtech.aopDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.mtech.aop.config.AppConfig;
import io.mtech.aop.service.TrafficeFortuneService;

public class AroundAdviceDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// get the bean from spring container
		TrafficeFortuneService theFortuneService = ctx.getBean("trafficeFortuneService", TrafficeFortuneService.class);
		System.out.println("\nMain Program: AroundAdviceDemoApp");

		// call method to find the accounts
		System.out.println("Calling getFortune.");
		String data = theFortuneService.getFortune();
		System.out.println("\nMy fortune Is: " + data);
		System.out.println("Finished.");
		// close the context
		ctx.close();
	}

}
