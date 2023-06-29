package io.mtech.aopDemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.mtech.aop.config.AppConfig;
import io.mtech.aop.service.TrafficeFortuneService;

public class AroundAdviceWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundAdviceWithLoggerDemoApp.class.getName());
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// get the bean from spring container
		TrafficeFortuneService theFortuneService = ctx.getBean("trafficeFortuneService", TrafficeFortuneService.class);
		myLogger.info("\nMain Program: AroundAdviceDemoApp");

		// call method to find the accounts
		myLogger.info("Calling getFortune.");
		String data = theFortuneService.getFortune();
		myLogger.info("\nMy fortune Is: " + data);
		myLogger.info("Finished.");
		// close the context
		ctx.close();
	}

}
