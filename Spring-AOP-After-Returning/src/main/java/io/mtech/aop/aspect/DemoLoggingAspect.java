package io.mtech.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.mtech.aop.entity.Account;

@Aspect
@Component
@Order(0)
public class DemoLoggingAspect {

	// add a new advice for @afterReturning on the findAccounts method

	@AfterReturning(pointcut = "execution(* io.mtech.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturingFidAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>Executing @AfterReturning on method: "
		        + method);

		// print out the results of the method call
		System.out.println("\n========> result is: " + result);

		// let's post-process the data....let's modify it :-)

		// convert the account names to upperCase
		convertAccountNamesToUpperCase(result);

		System.out.println("\n========>After modified result is: " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for (Account tempAccount : result) {
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			// update the name on the account
			tempAccount.setName(theUpperName);
		}

	}

	// this is where we add all our related advices for logging

	@Before("io.mtech.aop.aspect.MtechAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n========Executing @Before advice on addAccount()");

		// Display the method signature arguments
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);

		// display method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;

				System.out.println("Account Name: " + theAccount.getName());
				System.out.println("Account Level: " + theAccount.getLevel());
			}
		}
	}

}
