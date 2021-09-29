package io.mtech.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		City city = (City) ctx.getBean("myCity");

		city.cityName();

		((ClassPathXmlApplicationContext) ctx).close();
	}
}
