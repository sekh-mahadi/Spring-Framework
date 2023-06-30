package io.mtech.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import javax.naming.spi.DirStateFactory.Result;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* io.mtech.aop.service.*.getFortune(..))")
	public Object afterGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception exc) {
			myLogger.warning(exc.getMessage());
			result = "Mojor accident! no worries your private AOP helicopter is on the way.";
		}
		return result;
	}

	@Around("execution(* io.mtech.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theExc) throws Throwable {

		// print out method we are advising on
		// print out which method we are advising on
		String method = theExc.getSignature().toShortString();
		myLogger.info("\n=====>Executing @AfterReturning on method: "
		        + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now let's execute the method
		Object result = theExc.proceed();

		// get end timestamp
		long end = System.currentTimeMillis();
		// compute duration and display it
		long duration = end - begin;

		myLogger.info("\n======>>>Duration: " + duration / 1000.0
		        + " Seconds");
		return result;
	}

	@After("execution(* io.mtech.aop.dao.AccountDAO.findAccounts(..))")
	public void afterAdviceFidAccountAdvice(JoinPoint theJoinPoint) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>Executing @AfterAdvice on method: "
		        + method);

	}

	@AfterThrowing(pointcut = "execution(* io.mtech.aop.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingingFidAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>Executing @AfterReturning on method: "
		        + method);

		// log the exception

		myLogger.info("\n============> The exception Is: " + theExc);

	}
	// add a new advice for @afterReturning on the findAccounts method

	@AfterReturning(pointcut = "execution(* io.mtech.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturingFidAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>Executing @AfterReturning on method: "
		        + method);

		// print out the results of the method call
		myLogger.info("\n========> result is: " + result);

		// let's post-process the data....let's modify it :-)

		// convert the account names to upperCase
		convertAccountNamesToUpperCase(result);

		myLogger.info("\n========>After modified result is: " + result);

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
		myLogger.info("\n========Executing @Before advice on addAccount()");

		// Display the method signature arguments
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);

		// display method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;

				myLogger.info("Account Name: " + theAccount.getName());
				myLogger.info("Account Level: " + theAccount.getLevel());
			}
		}
	}

}
