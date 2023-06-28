package io.mtech.aopDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.mtech.aop.config.AppConfig;
import io.mtech.aop.dao.AccountDAO;
import io.mtech.aop.dao.MembershipDAO;
import io.mtech.aop.entity.Account;

public class MainApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = ctx.getBean("accountDAO", AccountDAO.class);

		// call the account getter.setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("Silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// get the bean from spring container
		MembershipDAO theMembershipDAO = ctx.getBean("membershipDAO", MembershipDAO.class);

		// Call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");

		theAccountDAO.addAccount(myAccount, true);

		theMembershipDAO.addAccount();
		theAccountDAO.doWork();

		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

		// do its again
		System.out.println("\n let's call it again!\n");

		// Call the business method again
		// theAccountDAO.addAccount();
		// close the context
		ctx.close();
	}

}
