package io.mtech.aopDemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.mtech.aop.config.AppConfig;
import io.mtech.aop.dao.AccountDAO;
import io.mtech.aop.dao.MembershipDAO;
import io.mtech.aop.entity.Account;

public class AfterReturningDemo {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = ctx.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program : AfterRetuningDemo");
		System.out.println("------");

		System.out.println(theAccounts);

		System.out.println("\n");

		// close the context
		ctx.close();
	}

}
