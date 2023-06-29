package io.mtech.aopDemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.mtech.aop.config.AppConfig;
import io.mtech.aop.dao.AccountDAO;
import io.mtech.aop.dao.MembershipDAO;
import io.mtech.aop.entity.Account;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = ctx.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program ... Caught Exception: " + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program : AfterThrowingDemoApp");
		System.out.println("------");

		System.out.println(theAccounts);

		System.out.println("\n");

		// close the context
		ctx.close();
	}

}
